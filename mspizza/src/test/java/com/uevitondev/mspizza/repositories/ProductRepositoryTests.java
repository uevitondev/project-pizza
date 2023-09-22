package com.uevitondev.mspizza.repositories;

import com.uevitondev.mspizza.entities.Product;
import com.uevitondev.mspizza.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;
    private long existingId;
    private long nonExistingId;
    private long countTotalProducts;

    @BeforeEach
    void setup() throws Exception {
        existingId = 1L;
        nonExistingId = 0L;
        countTotalProducts = 5L;
    }

    @Test
    void findProductsByPizzeriaIdShouldReturnListWhenPizzeriaIdExists() {
        List<Product> listProducts = productRepository.findProductsByPizzeriaId(existingId);

        Assertions.assertFalse(listProducts.isEmpty());
        Assertions.assertInstanceOf(Product.class, listProducts.get(0));
    }

    @Test
    void deleteByIdShouldDeleteProductWhenIdExists() {
        productRepository.deleteById(existingId);
        Optional<Product> product = productRepository.findById(existingId);

        Assertions.assertFalse(product.isPresent());
    }

    @Test
    void saveShouldPersistWithAutoIncrementWhenIdIsNull() {
        Product product = Factory.createProduct();
        product.setId(null);
        product = productRepository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1, product.getId());
    }
}
