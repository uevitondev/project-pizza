package com.uevitondev.mspizza.repositories;

import com.uevitondev.mspizza.entities.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzeriaRepository extends JpaRepository<Pizzeria, Long> {
}
