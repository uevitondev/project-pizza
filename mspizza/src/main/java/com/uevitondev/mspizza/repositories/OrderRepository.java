package com.uevitondev.mspizza.repositories;

import com.uevitondev.mspizza.entities.Order;
import com.uevitondev.mspizza.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Transactional
    List<Order> findByUser(User user);
}