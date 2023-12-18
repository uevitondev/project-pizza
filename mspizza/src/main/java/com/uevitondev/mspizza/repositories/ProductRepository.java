package com.uevitondev.mspizza.repositories;

import com.uevitondev.mspizza.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN FETCH p.category  JOIN FETCH p.pizzeria JOIN FETCH p.images")
    Page<Product> findAllProductsPaged(Pageable pageable);

    @Query("SELECT p FROM Product p JOIN FETCH p.category  JOIN FETCH p.pizzeria JOIN FETCH p.images where p.pizzeria.id = :id")
    Page<Product> findAllProductsPagedByPizzeriaId(Long id, Pageable pageable);

}