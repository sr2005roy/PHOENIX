package com.ecommerce.backendtwo.controller;

import com.ecommerce.backendtwo.entity.Cart;
import com.ecommerce.backendtwo.entity.CartItem;
import com.ecommerce.backendtwo.service.CartService;
import com.ecommerce.backendtwo.service.JwtService;
import com.ecommerce.backendtwo.entity.OrderItem;
import com.ecommerce.backendtwo.entity.User;
import com.ecommerce.backendtwo.entity.embeddable.Product;
import com.ecommerce.backendtwo.service.CartItemService;
import com.ecommerce.backendtwo.service.OrderItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
    private OrderController underTest;
    @Mock private CartService cartService;
    @Mock private CartItemService cartItemService;
    @Mock private OrderItemService orderItemService;
    @Mock private JwtService jwtService;
    @BeforeEach
    void setUp() {
        underTest = new OrderController(cartService, cartItemService, orderItemService, jwtService);
    }

    @Test
    void getOrders_ShouldQueryAllOrderItemsOfUser() {
        // Given
        String token = "jwt-token";
        User user = new User();
        user.setUserId(1);
        when(jwtService.decode(token)).thenReturn(user);

        // When
        underTest.getOrders(token);

        // Then
        verify(orderItemService).getOrdersOfUser(user);
    }

    @Test
    void addOrders_ShouldAddCartItemsToOrders() {
        // Given
        String token = "jwt-token";
        User user = new User();
        user.setUserId(1);
        Product product = new Product();
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        Cart cart = new Cart();
        cart.setCartItems(cartItems);

        when(jwtService.decode(token)).thenReturn(user);
        when(cartService.getCartByUser(user)).thenReturn(cart);

        // When
        underTest.addOrders(token);

        // Then
        ArgumentCaptor<List<OrderItem>> orderItemsCaptor = ArgumentCaptor.forClass(List.class);
        verify(orderItemService).addOrdersOfUser(orderItemsCaptor.capture());
        assert(orderItemsCaptor.getValue().size() == 1);

        ArgumentCaptor<List<Integer>> cartItemsCaptor = ArgumentCaptor.forClass(List.class);
        verify(cartItemService).removeCartItemsById(cartItemsCaptor.capture());
        assert(orderItemsCaptor.getValue().size() == 1);

    }
}