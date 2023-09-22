package com.uevitondev.mspizza.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uevitondev.mspizza.config.JwtAuthenticationFilter;
import com.uevitondev.mspizza.dtos.ProductDTO;
import com.uevitondev.mspizza.entities.Product;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.services.ProductService;
import com.uevitondev.mspizza.tests.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
class ProductControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private ObjectMapper objectMapper;
    private List<ProductDTO> listProductsDto;
    private Product product;
    private ProductDTO productDTO;
    private Long existingId;
    private Long nonExistingId;


    @BeforeEach()
    void setup() throws Exception {
        existingId = 1L;
        nonExistingId = 10000L;
        product = Factory.createProduct();
        productDTO = new ProductDTO(product);
        listProductsDto = List.of(new ProductDTO(product), new ProductDTO(product));

        when(productService.findAllProducts()).thenReturn(listProductsDto);
        when(productService.findProductById(nonExistingId)).thenThrow(ResourceNotFoundException.class);
        when(productService.findProductById(existingId)).thenReturn(productDTO);
        when(productService.updateProductById(existingId, productDTO)).thenReturn(productDTO);
        when(productService.updateProductById(nonExistingId, productDTO)).thenThrow(ResourceNotFoundException.class);

    }

    @Test
    void findAllProductsShouldReturnListOfProductDTO() throws Exception {
        ResultActions result = mockMvc.perform(get("/products").accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.[0].id").exists());
        result.andExpect(jsonPath("$.[1].id").exists());
    }

    @Test
    void findProductByIdShouldReturnProductDtoWhenIdExists() throws Exception {
        ResultActions result = mockMvc.perform(get("/products/{id}", existingId).accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        System.out.println(result.toString());
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.name").exists());
    }

    @Test
    void findProductByIdShouldReturnStatusNotFoundWhenIdDoesNotExist() throws Exception {
        ResultActions result = mockMvc.perform(get("/products/{id}", nonExistingId).accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }

    @Test
    void updateProductByIdShouldUpdateResourceAndReturnProductDtoWhenIdExists() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(productDTO);
        ResultActions result = mockMvc.perform(get("/products/{id}", existingId).content(jsonBody)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
    }

    @Test
    void updateProductByIdShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(productDTO);
        ResultActions result = mockMvc.perform(get("/products/{id}", nonExistingId).content(jsonBody)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }
}
