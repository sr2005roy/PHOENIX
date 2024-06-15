package com.ecommerce.backendtwo.service;

import com.ecommerce.backendtwo.entity.CartItem;
import com.ecommerce.backendtwo.repository.CartItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartItemServiceTest {
    private CartItemService underTest;
    @Mock private CartItemRepository cartItemRepository;

    @BeforeEach
    void setUp() {
        underTest = new CartItemService(cartItemRepository);
    }

    @Test
    void getCartItemById_ShouldReturnCartItem() {
        // Given
        Integer cartItemId = 1;
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(cartItemId);
        when(cartItemRepository.findById(cartItemId)).thenReturn(Optional.of(cartItem));

        // When
        CartItem returnedCartItem = underTest.getCartItemById(cartItemId);

        // Then
        assertEquals(cartItem, returnedCartItem);
    }

    @Test
    void addCartItem_ShouldSaveCartItem() {
        // Given
        Integer cartItemId = 1;
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(cartItemId);
        when(cartItemRepository.save(cartItem)).thenReturn(cartItem);

        // When
        underTest.addCartItem(cartItem);

        // Then
        verify(cartItemRepository).save(cartItem);
    }

    @Test
    void addCartItem_ShouldReturnCartItem() {
        // Given
        Integer cartItemId = 1;
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(cartItemId);
        when(cartItemRepository.save(cartItem)).thenReturn(cartItem);

        // When
        CartItem returnedCartItem = underTest.addCartItem(cartItem);

        // Then
        assertEquals(cartItem, returnedCartItem);
    }

    @Test
    void updateCartItem_ShouldUpdateCartItem() {
        // Given
        Integer cartItemId = 1;
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(cartItemId);
        when(cartItemRepository.save(cartItem)).thenReturn(cartItem);

        // When
        underTest.updateCartItem(cartItem);

        // Then
        verify(cartItemRepository).save(cartItem);
    }

    @Test
    void removeCartItemById_ShouldRemoveCartItem() {
        // Given
        Integer cartItemId = 1;

        // When
        underTest.removeCartItemById(cartItemId);

        // Then
        verify(cartItemRepository).deleteById(cartItemId);
    }

    @Test
    void removeCartItemsById_ShouldRemoveCartItems() {
        // Given
        List<Integer> ids = Arrays.asList(1, 2, 3, 4);

        // When
        underTest.removeCartItemsById(ids);

        // Then
        verify(cartItemRepository).deleteAllById(ids);
    }
}