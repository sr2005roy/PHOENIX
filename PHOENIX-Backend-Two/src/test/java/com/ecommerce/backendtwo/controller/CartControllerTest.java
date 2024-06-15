package com.ecommerce.backendtwo.controller;

import com.ecommerce.backendtwo.entity.Cart;
import com.ecommerce.backendtwo.entity.CartItem;
import com.ecommerce.backendtwo.service.CartService;
import com.ecommerce.backendtwo.service.JwtService;
import com.ecommerce.backendtwo.entity.User;
import com.ecommerce.backendtwo.entity.embeddable.Product;
import com.ecommerce.backendtwo.service.CartItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartControllerTest {
    private CartController underTest;
    @Mock private CartService cartService;
    @Mock private CartItemService cartItemService;
    @Mock private JwtService jwtService;

    @BeforeEach
    void setUp() {
        underTest = new CartController(cartService, cartItemService, jwtService);
    }

    @Test
    void getCart_ShouldReturnCart() {
        // Given
        String token = "jwt-token";
        User user = new User();
        user.setUserId(1);
        Cart cart = new Cart();
        cart.setCartId(1);
        cart.setUser(user);
        when(jwtService.decode(token)).thenReturn(user);
        when(cartService.getCartByUser(user)).thenReturn(cart);

        // When
        ResponseEntity<Cart> response = underTest.getCart(token);

        // Then
        assert(Objects.equals(response.getBody(), cart));
    }

    @Test
    void addItemToCart_ShouldSaveCartItem() {
        // Given
        String token = "jwt-token";
        Integer productId = 1;
        User user = new User();
        user.setUserId(1);
        Cart cart = new Cart();
        cart.setCartId(1);
        cart.setUser(user);
        when(jwtService.decode(token)).thenReturn(user);
        when(cartService.getCartByUser(user)).thenReturn(cart);

        // When
        underTest.addItemToCart(token, productId);

        // Then
        ArgumentCaptor<CartItem> captor = ArgumentCaptor.forClass(CartItem.class);
        verify(cartItemService).addCartItem(captor.capture());
        CartItem capturedCartItem = captor.getValue();
        assertEquals(cart, capturedCartItem.getCart());
        assertEquals(productId, capturedCartItem.getProduct().getProductId());
    }

    @Test
    void removeItemFromCart_ShouldRemoveCartItem() {
        // Given
        String token = "jwt-token";
        Integer cartItemId = 1;
        User user = new User();
        user.setUserId(1);
        Cart cart = new Cart();
        cart.setCartId(1);
        cart.setUser(user);
        when(jwtService.decode(token)).thenReturn(user);

        // When
        underTest.removeItemFromCart(token, cartItemId);

        // Then
        verify(cartItemService).removeCartItemById(cartItemId);
    }

    @Test
    void updateItemInCart_ShouldUpdateCartItem() {
        // Given
        String token = "jwt-token";
        Integer cartItemId = 1;
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(cartItemId);
        cartItem.setQuantity(3);
        CartItem savedCartItem = new CartItem();
        savedCartItem.setCartItemId(cartItemId);
        savedCartItem.setQuantity(2);
        User user = new User();
        user.setUserId(1);
        Cart cart = new Cart();
        cart.setCartId(1);
        cart.setUser(user);
        when(jwtService.decode(token)).thenReturn(user);
        when(cartItemService.getCartItemById(cartItemId)).thenReturn(savedCartItem);

        // When
        underTest.updateItemInCart(token, cartItem);

        // Then
        savedCartItem.setQuantity(cartItem.getQuantity());
        verify(cartItemService).updateCartItem(savedCartItem);
    }

    @Test
    void getItemFromCart_ShouldReturnCartItem() {
        // Given
        String token = "jwt-token";
        Integer productId = 1;
        User user = new User();
        user.setUserId(1);
        Product product = new Product();
        product.setProductId(productId);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        Cart cart = new Cart();
        cart.setCartId(1);
        cart.setUser(user);
        cart.setCartItems(cartItems);

        when(jwtService.decode(token)).thenReturn(user);
        when(cartService.getCartByUser(user)).thenReturn(cart);

        // When
        ResponseEntity<CartItem> response = underTest.getItemFromCart(token, productId);

        // Then
        assertEquals(productId, response.getBody().getProduct().getProductId());
    }
}