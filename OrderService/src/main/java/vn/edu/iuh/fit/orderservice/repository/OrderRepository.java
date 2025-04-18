/*
 * @ (#) OrderRepository.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.orderservice.model.Order;

/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
