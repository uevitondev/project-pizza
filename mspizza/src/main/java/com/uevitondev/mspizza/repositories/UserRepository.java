package com.uevitondev.mspizza.repositories;

import com.uevitondev.mspizza.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT obj FROM User obj JOIN FETCH obj.roles WHERE obj.email = :userName")
    Optional<User> findByEmail(String userName);


}
