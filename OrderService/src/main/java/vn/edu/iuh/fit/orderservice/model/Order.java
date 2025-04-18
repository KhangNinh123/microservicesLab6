/*
 * @ (#) Order.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.orderservice.model;
/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.orderservice.common.OrderStatus;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long customerId;

    private Long productId;

    private Integer quantity;

    private OrderStatus orderStatus;
}
