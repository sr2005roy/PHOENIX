package com.ecommerce.backendone.service;

import com.ecommerce.backendone.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    private CategoryService underTest;
    @Mock private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        underTest = new CategoryService(categoryRepository);
    }

    @Test
    void getCategoryById_ShouldInvokeRepositoryFunction() {
        // Given
        Integer id = 1;

        // When
        underTest.getCategoryById(id);

        // Then
        verify(categoryRepository).findById(id);
    }

}