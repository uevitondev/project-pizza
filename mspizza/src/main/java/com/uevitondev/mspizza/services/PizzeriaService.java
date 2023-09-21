package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.dtos.PizzeriaDTO;
import com.uevitondev.mspizza.dtos.ProductDTO;
import com.uevitondev.mspizza.entities.Pizzeria;
import com.uevitondev.mspizza.exceptions.DatabaseException;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.PizzeriaRepository;
import com.uevitondev.mspizza.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzeriaService {
    @Autowired
    private PizzeriaRepository pizzeriaRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<PizzeriaDTO> findAllPizzerias() {
        return pizzeriaRepository.findAll().stream().map(PizzeriaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public PizzeriaDTO findPizzeriaById(Long id) {
        Pizzeria pizzeria = pizzeriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("pizzeria not found, for id: " + id));
        return new PizzeriaDTO(pizzeria);
    }

    @Transactional
    public PizzeriaDTO insertNewPizzeria(PizzeriaDTO dto) {
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.setName(dto.getName());
        pizzeria = pizzeriaRepository.save(pizzeria);

        return new PizzeriaDTO(pizzeria);
    }

    @Transactional
    public PizzeriaDTO updatePizzeriaById(Long id, PizzeriaDTO dto) {
        try {
            Pizzeria pizzeria = pizzeriaRepository.getReferenceById(id);
            pizzeria.setName(dto.getName());
            pizzeria = pizzeriaRepository.save(pizzeria);
            return new PizzeriaDTO(pizzeria);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("pizzeria not found, for id: " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletePizzeriaById(Long id) {
        if (!pizzeriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("pizzeria not found, for id: " + id);
        }
        try {
            pizzeriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity constraint violation");
        }
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProductsByPizzeriaId(Long id) {
        return productRepository.findProductsByPizzeriaId(id).stream().map(ProductDTO::new).toList();
    }
}
