package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.entities.Product;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional()
    public List<Product> getAllProducts() {
        return null;
    }

    @Transactional()
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found, for id: " + id));
        return null;
    }
}
