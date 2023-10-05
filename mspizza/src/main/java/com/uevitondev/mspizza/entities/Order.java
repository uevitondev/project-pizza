package com.uevitondev.mspizza.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant instant;
    private String description;
    private String status;
    private Double total;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pizzeria_id")
    private Pizzeria pizzeria;
    @OneToMany(mappedBy = "order")
    private final Set<OrderItem> orderItems = new HashSet<>();

    public Order() {
    }

    public Order(Long id, Instant instant, String description, String status, Double total) {
        this.id = id;
        this.instant = instant;
        this.description = description;
        this.status = status;
        this.total = total;
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

    public void setTotal() {
        double sum = 0.0;
        for (OrderItem orderItem : getOrderItems()) {
            sum += orderItem.getSubtotal();
        }
        this.total = sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public void setPizzeria(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
}
