package ngduc.customerservice.service;

import ngduc.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> getAll();
    Customer getById(Long id);
    Customer update(Long id, Customer customer);
    void delete(Long id);
}