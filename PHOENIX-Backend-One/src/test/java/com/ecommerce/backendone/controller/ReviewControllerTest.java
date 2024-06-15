package com.ecommerce.backendone.controller;

import com.ecommerce.backendone.entity.Product;
import com.ecommerce.backendone.entity.Review;
import com.ecommerce.backendone.service.FetchService;
import com.ecommerce.backendone.service.ProductService;
import com.ecommerce.backendone.service.ReviewService;
import com.ecommerce.backendone.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewControllerTest {

    private ReviewController underTest;
    @Mock private FetchService fetchService;
    @Mock private ProductService productService;
    @Mock private ReviewService reviewService;

    @BeforeEach
    void setUp() {
        underTest = new ReviewController(fetchService, productService, reviewService);
    }

    private Product getProduct(Integer productId, Integer reviewCount, Integer totalRating) {
        Product product = new Product();
        product.setProductId(productId);
        product.setReviewCount(reviewCount);
        product.setTotalRating(totalRating);
        return product;
    }

    private Review getReview(Integer reviewId, Integer userId, Product product, Integer rating) {
        Review review = new Review();
        review.setReviewId(reviewId);
        review.setRating(rating);
        review.setUserId(userId);
        review.setProduct(product);
        return review;
    }

    @Test
    void addReview_ShouldAddReview() {
        // Given
        Integer productId = 1;
        Integer reviewCount = 3;
        Integer totalRating = 12;
        Integer userId = 1;
        Integer reviewId = 1;
        Integer rating = 4;
        String token = "jwt-token";

        Product product = getProduct(productId, reviewCount, totalRating);
        Review review = getReview(reviewId, userId, product, rating);
        Product updatedProduct = getProduct(productId, reviewCount + 1, totalRating + rating);
        User tokenUser = new User();
        tokenUser.setUserId(userId);

        when(fetchService.validateToken(token)).thenReturn(tokenUser);
        when(productService.getProductById(productId)).thenReturn(product);
        when(productService.updateProduct(product)).thenReturn(updatedProduct);

        // When
        underTest.addReview(token, review);

        // Then
        verify(reviewService).addReview(review);
    }

    @Test
    void addReview_ShouldUpdateProduct() {
        // Given
        Integer productId = 1;
        Integer reviewCount = 3;
        Integer totalRating = 12;
        Integer userId = 1;
        Integer reviewId = 1;
        Integer rating = 4;
        String token = "jwt-token";

        Product product = getProduct(productId, reviewCount, totalRating);
        Review review = getReview(reviewId, userId, product, rating);
        Product updatedProduct = getProduct(productId, reviewCount + 1, totalRating + rating);
        User tokenUser = new User();
        tokenUser.setUserId(userId);

        when(fetchService.validateToken(token)).thenReturn(tokenUser);
        when(productService.getProductById(productId)).thenReturn(product);
        when(productService.updateProduct(product)).thenReturn(updatedProduct);

        // When
        underTest.addReview(token, review);

        // Then
        verify(productService).updateProduct(updatedProduct);
    }

    @Test
    void deleteReview_ShouldDeleteReview() {
        // Given
        Integer productId = 1;
        Integer reviewCount = 3;
        Integer totalRating = 12;
        Integer userId = 1;
        Integer reviewId = 1;
        Integer rating = 4;
        String token = "jwt-token";

        Product product = getProduct(productId, reviewCount, totalRating);
        Review review = getReview(reviewId, userId, product, rating);
        Product updatedProduct = getProduct(productId, reviewCount - 1, totalRating - rating);
        User tokenUser = new User();
        tokenUser.setUserId(userId);

        when(fetchService.validateToken(token)).thenReturn(tokenUser);
        when(reviewService.getReviewById(reviewId)).thenReturn(review);
        when(productService.getProductById(productId)).thenReturn(product);
        when(productService.updateProduct(product)).thenReturn(updatedProduct);

        // When
        underTest.deleteReview(token, review);

        // Then
        verify(reviewService).deleteReviewById(reviewId);
    }

    @Test
    void deleteReview_ShouldUpdateProduct() {
        // Given
        Integer productId = 1;
        Integer reviewCount = 3;
        Integer totalRating = 12;
        Integer userId = 1;
        Integer reviewId = 1;
        Integer rating = 4;
        String token = "jwt-token";

        Product product = getProduct(productId, reviewCount, totalRating);
        Review review = getReview(reviewId, userId, product, rating);
        Product updatedProduct = getProduct(productId, reviewCount - 1, totalRating - rating);
        User tokenUser = new User();
        tokenUser.setUserId(userId);

        when(fetchService.validateToken(token)).thenReturn(tokenUser);
        when(reviewService.getReviewById(reviewId)).thenReturn(review);
        when(productService.getProductById(productId)).thenReturn(product);
        when(productService.updateProduct(product)).thenReturn(updatedProduct);

        // When
        underTest.deleteReview(token, review);

        // Then
        verify(productService).updateProduct(updatedProduct);
    }
}