package com.ecommerce.backendone.controller;

import com.ecommerce.backendone.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    private CategoryController underTest;
    @Mock private CategoryService categoryService;


    @BeforeEach
    void setUp() {
        underTest = new CategoryController(categoryService);
    }

    @Test
    void getCategory_ShouldQueryCategory() {
        // Given
        Integer id = 1;

        // When
        underTest.getCategory(id);

        // Then
        verify(categoryService).getCategoryById(id);
    }
}