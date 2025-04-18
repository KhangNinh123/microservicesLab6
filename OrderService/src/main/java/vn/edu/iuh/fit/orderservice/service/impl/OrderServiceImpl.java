/*
 * @ (#) OrderServiceImpl.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.orderservice.service.impl;
/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.orderservice.common.OrderStatus;
import vn.edu.iuh.fit.orderservice.model.Order;
import vn.edu.iuh.fit.orderservice.repository.OrderRepository;
import vn.edu.iuh.fit.orderservice.service.OrderService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "ORDER-SERVICE")
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Override
    public Order createOrder(Order order) {
        String customerUrl = "http://customer-service:8083/customers/" + order.getCustomerId();
        try{
            restTemplate.getForObject(customerUrl, Order.class);
        }catch (Exception e){
            throw new RuntimeException("Customer not found");
        }

        String productUrl = "http://product-service:8082/products/" + order.getProductId();
        try{
            restTemplate.getForObject(productUrl, Order.class);
        }catch (Exception e){
            throw new RuntimeException("Product not found");
        }

        order.setOrderStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
