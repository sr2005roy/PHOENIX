package com.ecommerce.backendtwo.service;

import com.ecommerce.backendtwo.entity.Cart;
import com.ecommerce.backendtwo.entity.User;
import com.ecommerce.backendtwo.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {
    private CartService underTest;
    @Mock private CartRepository cartRepository;
    @Mock private FetchService fetchService;

    @BeforeEach
    void setUp() {
        underTest = new CartService(cartRepository, fetchService);
    }

    @Test
    void getCartByUser_ShouldQueryCart() {
        // Given
        User user = new User();
        Cart cart = new Cart();
        cart.setCartId(1);
        when(cartRepository.findByUser(user)).thenReturn(Optional.of(cart));

        // When
        underTest.getCartByUser(user);

        // Then
        verify(cartRepository).findByUser(user);
    }

    @Test
    void getCartByUser_ShouldReturnCart() {
        // Given
        User user = new User();
        Cart cart = new Cart();
        cart.setCartId(1);
        when(cartRepository.findByUser(user)).thenReturn(Optional.of(cart));

        // When
        Cart returnedCart = underTest.getCartByUser(user);

        // Then
        assertNotNull(returnedCart);
    }

    @Test
    void addCartOfUser_ShouldSaveCart() {
        // Given
        User user = new User();
        Cart cart = new Cart();
        cart.setUser(user);

        // When
        underTest.addCartOfUser(user);

        // Then
        ArgumentCaptor<Cart> captor = ArgumentCaptor.forClass(Cart.class);
        verify(cartRepository).save(captor.capture());
        Cart capturedCart = captor.getValue();
        assertEquals(user, capturedCart.getUser());
    }
}