package com.ecommerce.backendone.service;

import com.ecommerce.backendone.entity.Review;
import com.ecommerce.backendone.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {
    private ReviewService underTest;
    @Mock private ReviewRepository reviewRepository;

    @BeforeEach
    void setUp() {
        underTest = new ReviewService(reviewRepository);
    }

    @Test
    void addReview_ShouldInvokeRepositoryMethod() {
        // Given
        Review review = new Review(1, 1, "User1", 3, "Nice Product!", null, null);

        // When
        underTest.addReview(review);

        // Then
        verify(reviewRepository).save(review);
    }

    @Test
    void deleteReviewById_ShouldInvokeRepositoryMethod() {
        // Given
        Integer id = 1;

        // When
        underTest.deleteReviewById(id);

        // Then
        verify(reviewRepository).deleteById(id);
    }
}