package com.ssmu.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssmu.security.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(String id);
    Product findByName(String name);

}
