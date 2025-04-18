/*
 * @ (#) OrderService.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.orderservice.service;
/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

import vn.edu.iuh.fit.orderservice.model.Order;

import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);

    Optional<Order> getOrderById(Long id);

    Order updateOrder(Order order);

    void deleteOrder(Long id);
}
