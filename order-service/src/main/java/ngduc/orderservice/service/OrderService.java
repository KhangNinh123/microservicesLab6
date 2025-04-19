package ngduc.orderservice.service;

import ngduc.orderservice.dto.*;
import ngduc.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    OrderResponse placeOrder(CreateOrderRequest request);
    List<OrderResponse> getAllOrders();
    OrderResponse getOrderDetail(Long id);
    Order getById(Long id);
    void delete(Long id);
}