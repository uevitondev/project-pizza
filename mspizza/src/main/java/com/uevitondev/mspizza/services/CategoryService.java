package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.entities.Category;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional()
    public List<Category> getAllCategories() {
        return null;
    }

    @Transactional()
    public Category getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found, for id: " + id));
        return null;
    }
}
