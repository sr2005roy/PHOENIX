package com.ecommerce.backendone.controller;

import com.ecommerce.backendone.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private ProductController underTest;
    @Mock private ProductService productService;

    @BeforeEach
    void setUp() {
        underTest = new ProductController(productService);
    }

    @Test
    void getProduct_ShouldQueryProduct() {
        // Given
        Integer id = 1;

        // When
        underTest.getProduct(id);

        // Then
        verify(productService).getProductById(id);
    }

    @Test
    void getProducts_ShouldQueryProducts() {
        // Given
        List<Integer> ids = List.of(1, 2, 3, 4);

        // When
        underTest.getProducts(ids);

        // Then
        for (Integer id : ids) {
            verify(productService).getProductById(id);
        }
    }

    @Test
    void getProductsWithTextLike_ShouldQueryProducts() {
        // Given
        String text = "some-text";

        // When
        underTest.getProductsWithTextLike(text);

        // Then
        verify(productService).getProductsWithText(text);

    }
}