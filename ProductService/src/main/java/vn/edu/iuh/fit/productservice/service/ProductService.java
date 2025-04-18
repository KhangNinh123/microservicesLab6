/*
 * @ (#) ProductService.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.productservice.service;
/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

import vn.edu.iuh.fit.productservice.model.Product;

import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    Optional<Product> getProductById(Long id);

    Product updateProduct(Product product);

    void deleteProduct(Long id);

}
