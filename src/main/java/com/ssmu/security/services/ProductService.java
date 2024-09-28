package com.ssmu.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssmu.security.model.Product;
import com.ssmu.security.repositories.ProductRepository;
import java.util.List;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }


   public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }


}