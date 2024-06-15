package com.ecommerce.backendone.repository;

import com.ecommerce.backendone.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE review_sequence SET next_val = 1", nativeQuery = true)
    void resetSequence();
}
