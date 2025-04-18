/*
 * @ (#) CustomerController.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.customerservice.controller;
/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.customerservice.model.Customer;
import vn.edu.iuh.fit.customerservice.service.CustomerService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
@Slf4j(topic = "CUSTOMER-CONTROLLER")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(Customer customer) {
        log.info("Creating customer: {}", customer);

        customer = customerService.createCustomer(customer);

        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Long id) {
        log.info("Getting customer by ID: {}", id);

        Optional<Customer> customer = customerService.getCustomerById(id);

        if (customer.isPresent()) {
            log.info("Customer found: {}", customer.get());

            return ResponseEntity.ok().body(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        log.info("Updating customer with ID: {}", id);

        customer = customerService.updateCustomer(customer);

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        log.info("Deleting customer with ID: {}", id);

        customerService.deleteCustomer(id);

        return ResponseEntity.noContent().build();
    }
}
