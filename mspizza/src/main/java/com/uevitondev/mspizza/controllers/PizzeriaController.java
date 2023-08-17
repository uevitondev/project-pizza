package com.uevitondev.mspizza.controllers;

import com.uevitondev.mspizza.dtos.PizzeriaDTO;
import com.uevitondev.mspizza.dtos.ProductDTO;
import com.uevitondev.mspizza.services.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pizzerias")
public class PizzeriaController {
    @Autowired
    private PizzeriaService pizzeriaService;

    @GetMapping
    public ResponseEntity<List<PizzeriaDTO>> getAllPizzerias() {
        return ResponseEntity.ok().body(pizzeriaService.getAllPizzerias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzeriaDTO> getPizzeriaById(@PathVariable Long id) {
        return ResponseEntity.ok().body(pizzeriaService.getPizzeriaById(id));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<ProductDTO>> getAllProductsByPizzeriaId(@PathVariable Long id) {
        return ResponseEntity.ok().body(pizzeriaService.getAllProductsByPizzeriaId(id));
    }
}
