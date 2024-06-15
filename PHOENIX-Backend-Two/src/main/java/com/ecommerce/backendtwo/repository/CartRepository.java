package com.ecommerce.backendtwo.repository;

import com.ecommerce.backendtwo.entity.Cart;
import com.ecommerce.backendtwo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByUser(User user);
}
