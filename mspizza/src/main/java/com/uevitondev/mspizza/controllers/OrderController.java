package com.uevitondev.mspizza.controllers;

import com.uevitondev.mspizza.dtos.OrderDTO;
import com.uevitondev.mspizza.dtos.ShoppingCartDTO;
import com.uevitondev.mspizza.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAllOrders() {
        return ResponseEntity.ok().body(orderService.findAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findOrderById(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.findOrderById(id));
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insertNewOrder(@RequestBody @Valid ShoppingCartDTO dto) {
        return ResponseEntity.ok().body(orderService.insertNewOrder(dto));
    }
}
