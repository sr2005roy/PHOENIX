package com.ecommerce.backendtwo.controller;

import com.ecommerce.backendtwo.entity.Cart;
import com.ecommerce.backendtwo.entity.CartItem;
import com.ecommerce.backendtwo.entity.User;
import com.ecommerce.backendtwo.service.CartService;
import com.ecommerce.backendtwo.service.JwtService;
import com.ecommerce.backendtwo.entity.OrderItem;
import com.ecommerce.backendtwo.service.CartItemService;
import com.ecommerce.backendtwo.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private JwtService jwtService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderItem>> getOrders(@RequestHeader(name = "Authorization") String token) {
        User user = jwtService.decode(token);
        List<OrderItem> orders = orderItemService.getOrdersOfUser(user);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/orders/add-orders")
    public ResponseEntity<Void> addOrders(@RequestHeader(name = "Authorization") String token) {
        User user = jwtService.decode(token);
        Cart cart = cartService.getCartByUser(user);
        List<OrderItem> orderItems = new ArrayList<>();
        List<Integer> cartItemIds = new ArrayList<>();
        for (CartItem cartItem: cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setUser(user);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setProductId(cartItem.getProduct().getProductId());
            orderItem.setProductName(cartItem.getProduct().getProductName());
            orderItem.setTotalPrice(cartItem.calculateAmount());
            orderItem.setImageUrl(cartItem.getProduct().getImageUrl());
            orderItems.add(orderItem);
            cartItemIds.add(cartItem.getCartItemId());
        }
        orderItemService.addOrdersOfUser(orderItems);
        cartItemService.removeCartItemsById(cartItemIds);
        return ResponseEntity.ok(null);
    }
}
