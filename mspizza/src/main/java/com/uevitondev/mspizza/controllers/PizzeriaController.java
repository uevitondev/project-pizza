package com.uevitondev.mspizza.controllers;

import com.uevitondev.mspizza.dtos.PizzeriaDTO;
import com.uevitondev.mspizza.services.PizzeriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pizzerias")
public class PizzeriaController {

    private final PizzeriaService pizzeriaService;

    public PizzeriaController(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzeriaDTO>> getAllPizzerias() {
        return ResponseEntity.ok().body(pizzeriaService.findAllPizzerias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzeriaDTO> getPizzeriaById(@PathVariable Long id) {
        return ResponseEntity.ok().body(pizzeriaService.findPizzeriaById(id));
    }

    @PostMapping
    public ResponseEntity<PizzeriaDTO> insertNewPizzeria(@RequestBody PizzeriaDTO dto) {
        dto = pizzeriaService.insertNewPizzeria(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzeriaDTO> updatePizzeriaById(@PathVariable Long id, @RequestBody PizzeriaDTO dto) {
        dto = pizzeriaService.updatePizzeriaById(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizzeriaById(@PathVariable Long id) {
        pizzeriaService.deletePizzeriaById(id);
        return ResponseEntity.noContent().build();
    }

}