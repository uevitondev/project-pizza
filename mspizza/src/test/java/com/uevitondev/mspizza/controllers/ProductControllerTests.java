package com.uevitondev.mspizza.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uevitondev.mspizza.config.JwtAuthenticationFilter;
import com.uevitondev.mspizza.dtos.ProductDTO;
import com.uevitondev.mspizza.entities.Product;
import com.uevitondev.mspizza.services.ProductService;
import com.uevitondev.mspizza.tests.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class, JwtAuthenticationFilter.class})
public class ProductControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    private List<ProductDTO> listProductsDto;
    private Product product;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach()
    void setup() throws Exception {
        product = Factory.createProduct();
        listProductsDto = List.of(new ProductDTO(product), new ProductDTO(product));

        when(productService.findAllProducts()).thenReturn(listProductsDto);
    }

    @Test
    void findAllProductsShouldReturnListOfProductDTO() throws Exception {
        mockMvc.perform(get("/products")).andExpect(status().isOk()).andExpect((ResultMatcher) jsonPath("$", hasSize(2)));
    }
}
