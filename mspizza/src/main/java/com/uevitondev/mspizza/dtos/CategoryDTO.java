package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.Category;
import com.uevitondev.mspizza.entities.Product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CategoryDTO implements Serializable {
    private Long id;
    private String name;
    private Set<ProductDTO> products = new HashSet<>();

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
        products.stream().map(product -> this.products.add(new ProductDTO(product)));
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
}
