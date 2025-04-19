package ngduc.productservice.service;

import ngduc.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> saveAll(List<Product> products);

    List<Product> getAll();

    Product getById(Long id);

    Product update(Long id, Product product);

    void delete(Long id);
}