/*
 * @ (#) OrderController.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.orderservice.controller;
/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.orderservice.model.Order;
import vn.edu.iuh.fit.orderservice.service.OrderService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "ORDER-CONTROLLER")
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(Order order) {
        log.info("Creating order: {}", order);

        Order createdOrder = orderService.createOrder(order);

        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable Long id) {
        log.info("Getting order by id: {}", id);

        Optional<Order> order = orderService.getOrderById(id);

        return ResponseEntity.ok().body(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        log.info("Updating order: {}", order);

        Order updatedOrder = orderService.updateOrder(order);

        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        log.info("Deleting order with id: {}", id);

        orderService.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }

}
