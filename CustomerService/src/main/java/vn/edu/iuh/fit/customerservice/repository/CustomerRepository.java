/*
 * @ (#) CustomerRepository.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.customerservice.repository;
/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.customerservice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
