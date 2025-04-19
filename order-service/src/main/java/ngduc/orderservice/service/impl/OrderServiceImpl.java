package ngduc.orderservice.service.impl;

import ngduc.orderservice.dto.*;
import ngduc.orderservice.external.CustomerClient;
import ngduc.orderservice.external.ProductClient;
import ngduc.orderservice.model.Order;
import ngduc.orderservice.model.OrderItem;
import ngduc.orderservice.repository.OrderRepository;
import ngduc.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private CustomerClient customerClient;

    @Override
    public OrderResponse placeOrder(CreateOrderRequest request) {
        CustomerDTO customer = request.getCustomer();

        Order order = Order.builder()
                .customerId(customer.getId())
                .createdAt(LocalDateTime.now())
                .items(request.getItems())
                .build();

        order = repository.save(order);

        double total = 0;
        List<OrderItemDTO> itemDTOs = new ArrayList<>();

        for (OrderItem item : order.getItems()) {
            ProductDTO product = productClient.getProductById(item.getProductId());
            double itemTotal = product.getPrice() * item.getQuantity();

            itemDTOs.add(new OrderItemDTO(product, item.getQuantity(), itemTotal));
            total += itemTotal;
        }

        return OrderResponse.builder()
                .orderId(order.getId())
                .customer(customer)
                .products(itemDTOs)
                .totalAmount(total)
                .createdAt(order.getCreatedAt())
                .build();
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = repository.findAll();
        List<OrderResponse> responseList = new ArrayList<>();

        for (Order order : orders) {
            CustomerDTO customer = customerClient.getCustomerById(order.getCustomerId());
            List<OrderItemDTO> itemDTOs = new ArrayList<>();
            double total = 0;

            for (OrderItem item : order.getItems()) {
                try {
                    ProductDTO product = productClient.getProductById(item.getProductId());
                    double itemTotal = product.getPrice() * item.getQuantity();
                    itemDTOs.add(new OrderItemDTO(product, item.getQuantity(), itemTotal));
                    total += itemTotal;
                } catch (RuntimeException e) {
                    // Log và bỏ qua sản phẩm lỗi
                    System.err.println("Product not found for ID: " + item.getProductId());
                }
            }

            OrderResponse response = OrderResponse.builder()
                    .orderId(order.getId())
                    .customer(customer)
                    .products(itemDTOs)
                    .totalAmount(total)
                    .createdAt(order.getCreatedAt())
                    .build();

            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public OrderResponse getOrderDetail(Long id) {
        Order order = getById(id);
        CustomerDTO customer = customerClient.getCustomerById(order.getCustomerId());
        List<OrderItemDTO> itemDTOs = new ArrayList<>();
        double total = 0;

        for (OrderItem item : order.getItems()) {
            ProductDTO product = productClient.getProductById(item.getProductId());
            double itemTotal = product.getPrice() * item.getQuantity();
            itemDTOs.add(new OrderItemDTO(product, item.getQuantity(), itemTotal));
            total += itemTotal;
        }

        return OrderResponse.builder()
                .orderId(order.getId())
                .customer(customer)
                .products(itemDTOs)
                .totalAmount(total)
                .createdAt(order.getCreatedAt())
                .build();
    }

    @Override
    public Order getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}