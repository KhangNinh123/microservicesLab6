/*
 * @ (#) ProductRepository.java       1.0     4/12/2025
 *
 * Copyright (c) 2025. All rights reserved.
 */

package vn.edu.iuh.fit.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.productservice.model.Product;

/*
 * @author: Luong Tan Dat
 * @date: 4/12/2025
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
