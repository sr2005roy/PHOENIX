package com.ecommerce.backendone.service;

import com.ecommerce.backendone.entity.Product;
import com.ecommerce.backendone.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private ProductService underTest;
    @Mock private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        underTest = new ProductService(productRepository);
    }

    @Test
    void getProductById_ShouldInvokeRepositoryFunction() {
        // Given
        Integer id = 1;

        // When
        underTest.getProductById(id);

        // Then
        verify(productRepository).findById(id);
    }

    @Test
    void getProductsWithText_ShouldReturnProductsWithText() {
        // Given
        String text = "some-text";
        Product product1 = new Product();
        product1.setProductName("Yellow bag");
        Product product2 = new Product();
        product1.setProductName("Red bag");
        Product[] products = {product1, product2};
        when(productRepository.findByProductNameContainingIgnoreCaseOrCategoryCategoryNameContainingIgnoreCase(text, text)).thenReturn(products);

        // When
        Product[] result = underTest.getProductsWithText(text);

        // Then
        assert(result.length == 2);
    }
}