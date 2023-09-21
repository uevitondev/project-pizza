package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.entities.Product;
import com.uevitondev.mspizza.exceptions.DatabaseException;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.ProductRepository;
import com.uevitondev.mspizza.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {
    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;
    private long existingId;
    private long nonExistingId;
    private long dependentId;
    private List<Product> listProducts;
    private Product product;

    @BeforeEach
    void setup() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        dependentId = 3L;
        product = Factory.createProduct();
        listProducts = List.of(product, product);

        Mockito.when(productRepository.existsById(existingId)).thenReturn(true);
        Mockito.when(productRepository.existsById(nonExistingId)).thenReturn(false);
        Mockito.when(productRepository.existsById(dependentId)).thenReturn(true);
        Mockito.doThrow(DataIntegrityViolationException.class).when(productRepository).deleteById(dependentId);
        Mockito.when(productRepository.findAll()).thenReturn(listProducts);
        Mockito.when(productRepository.save(ArgumentMatchers.any())).thenReturn(product);
        Mockito.when(productRepository.findById(existingId)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.findById(nonExistingId)).thenReturn(Optional.empty());
    }

    @Test
    void findAllShouldReturnListOfProducts() {
        List<Product> products = productRepository.findAll();

        Assertions.assertNotNull(products);
        Assertions.assertFalse(products.isEmpty());
        Mockito.verify(productRepository, Mockito.times(1)).findAll();
    }

    @Test
    void deleteShouldDoNothingWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            productService.deleteProductById(existingId);
        });
    }

    @Test
    void deleteShouldThrowResourceNotFoundExceptionExceptionWhenIdDoesNotExists() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            productService.deleteProductById(nonExistingId);
        });
    }

    @Test
    void deleteShouldThrowDatabaseExceptionExceptionWhenDependentId() {
        Assertions.assertThrows(DatabaseException.class, () -> {
            productService.deleteProductById(dependentId);
        });
    }
}
