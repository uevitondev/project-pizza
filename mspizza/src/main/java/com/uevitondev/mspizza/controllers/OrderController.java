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
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insertNewOrder(@RequestBody @Valid ShoppingCartDTO dto) {
        return ResponseEntity.ok().body(orderService.insertNewOrder(dto));
    }
}
