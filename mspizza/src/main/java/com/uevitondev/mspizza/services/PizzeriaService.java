package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.dtos.PizzeriaDTO;
import com.uevitondev.mspizza.dtos.ProductDTO;
import com.uevitondev.mspizza.entities.Pizzeria;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.PizzeriaRepository;
import com.uevitondev.mspizza.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzeriaService {
    @Autowired
    private PizzeriaRepository pizzeriaRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional()
    public List<PizzeriaDTO> getAllPizzerias() {
        return pizzeriaRepository.findAll().stream().map(PizzeriaDTO::new).toList();
    }

    @Transactional()
    public PizzeriaDTO getPizzeriaById(Long id) {
        Pizzeria pizzeria = pizzeriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("pizzeria not found, for id: " + id));
        return new PizzeriaDTO(pizzeria, pizzeria.getProducts());
    }

    public List<ProductDTO> getAllProductsByPizzeriaId(Long id) {
        return productRepository.findProductsByPizzeriaId(id).stream().map(ProductDTO::new).toList();
    }
}
