/*
 * @ (#) CustomerService.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.customerservice.service;
/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

import vn.edu.iuh.fit.customerservice.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Optional<Customer> getCustomerById(Long id);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}
