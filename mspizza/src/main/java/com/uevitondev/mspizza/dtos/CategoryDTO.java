package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.Category;
import com.uevitondev.mspizza.entities.Product;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CategoryDTO implements Serializable {
    private Long id;
    @NotBlank(message = "name: is mandatory")
    private String name;
    private final Set<ProductDTO> products = new HashSet<>();

    public CategoryDTO() {

    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public CategoryDTO(Category category, Set<Product> products) {
        this.id = category.getId();
        this.name = category.getName();
        products.forEach(product -> this.products.add(new ProductDTO(product)));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }
}
