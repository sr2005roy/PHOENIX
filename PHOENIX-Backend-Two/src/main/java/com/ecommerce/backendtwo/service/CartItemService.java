package com.ecommerce.backendtwo.service;

import com.ecommerce.backendtwo.entity.CartItem;
import com.ecommerce.backendtwo.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartItemService {
    @Autowired
    private CartItemRepository repository;

    public CartItem getCartItemById(Integer cartItemId) {
        return repository.findById(cartItemId).orElse(null);
    }

    public CartItem addCartItem(CartItem cartItem) {
        return repository.save(cartItem);
    }

    public void updateCartItem(CartItem cartItem) {
        repository.save(cartItem);
    }

    public void removeCartItemById(Integer cartItemId) {
        repository.deleteById(cartItemId);
    }

    public void removeCartItemsById(List<Integer> cartItemIds) {
        repository.deleteAllById(cartItemIds);
    }

}
