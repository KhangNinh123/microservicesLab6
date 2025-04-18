/*
 * @ (#) ProductController.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.productservice.controller;
/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.productservice.model.Product;
import vn.edu.iuh.fit.productservice.service.ProductService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "PRODUCT-CONTROLLER")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(Product product) {
        log.info("Create product: {}", product);

        product = productService.createProduct(product);

        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductFromId(@PathVariable Long id){
        log.info("Get product from id: {}", id);

        Optional<Product> product = productService.getProductById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok().body(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(Product product) {
        log.info("Update product: {}", product);

        Product updatedProduct = productService.updateProduct(product);

        if (updatedProduct != null) {
            return ResponseEntity.ok().body(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.info("Delete product with id: {}", id);

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

}
