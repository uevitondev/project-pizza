package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.Order;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO implements Serializable {
    private Long id;
    private Instant instant;
    private String description;
    private String status;
    private Double total;
    private Long userId;
    private Long pizzeriaId;
    private List<OrderItemDTO> orderItems = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(Long id, Instant instant, String description, String status, Double total, Long userId, Long pizzeriaId) {
        this.id = id;
        this.instant = instant;
        this.description = description;
        this.status = status;
        this.total = total;
        this.userId = userId;
        this.pizzeriaId = pizzeriaId;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.instant = order.getInstant();
        this.description = order.getDescription();
        this.status = order.getStatus();
        this.total = order.getTotal();
        this.userId = order.getUser().getId();
        this.pizzeriaId = order.getPizzeria().getId();
        this.orderItems = order.getOrderItems().stream().map(OrderItemDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPizzeriaId() {
        return pizzeriaId;
    }

    public void setPizzeriaId(Long pizzeriaId) {
        this.pizzeriaId = pizzeriaId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
