package com.ecommerce.backendtwo.repository;

import com.ecommerce.backendtwo.entity.User;
import com.ecommerce.backendtwo.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByUser(User user);
}
