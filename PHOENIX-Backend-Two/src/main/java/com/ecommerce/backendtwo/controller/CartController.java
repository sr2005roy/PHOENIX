package com.ecommerce.backendtwo.controller;

import com.ecommerce.backendtwo.service.CartService;
import com.ecommerce.backendtwo.service.JwtService;
import com.ecommerce.backendtwo.entity.Cart;
import com.ecommerce.backendtwo.entity.CartItem;
import com.ecommerce.backendtwo.entity.User;
import com.ecommerce.backendtwo.entity.embeddable.Product;
import com.ecommerce.backendtwo.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private JwtService jwtService;

    @GetMapping("/cart")
    public ResponseEntity<Cart> getCart(@RequestHeader(name = "Authorization") String token) {
        User user = jwtService.decode(token);
        Cart cart = cartService.getCartByUser(user);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/cart/add-item")
    public ResponseEntity<Void> addItemToCart(@RequestHeader(name = "Authorization") String token, @RequestBody Integer productId) {
        User user = jwtService.decode(token);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(new Product());
        cartItem.getProduct().setProductId(productId);
        cartItem.setQuantity(1);
        Cart cart = cartService.getCartByUser(user);
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/cart/remove-item")
    public ResponseEntity<Cart> removeItemFromCart(@RequestHeader(name = "Authorization") String token, @RequestBody Integer cartItemId) {
        User user = jwtService.decode(token);
        cartItemService.removeCartItemById(cartItemId);
        Cart cart = cartService.getCartByUser(user);
        return ResponseEntity.ok(cart);
    }

    @PatchMapping("/cart/update-item")
    public ResponseEntity<Cart> updateItemInCart(@RequestHeader(name = "Authorization") String token, @RequestBody CartItem cartItem) {
        User user = jwtService.decode(token);
        CartItem savedCartItem = cartItemService.getCartItemById(cartItem.getCartItemId());
        if (savedCartItem == null) throw new RuntimeException("Could not find item in cart");
        savedCartItem.setQuantity(cartItem.getQuantity());
        cartItemService.updateCartItem(savedCartItem);
        Cart cart = cartService.getCartByUser(user);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/cart/get-item")
    public ResponseEntity<CartItem> getItemFromCart(@RequestHeader(name = "Authorization") String token, @RequestBody Integer productId) {
        User user = jwtService.decode(token);
        Cart cart = cartService.getCartByUser(user);
        CartItem cartItem = null;
        for (CartItem item: cart.getCartItems()) {
            if (item.getProduct().getProductId().intValue() == productId.intValue()) {
                cartItem = item;
                break;
            }
        }
        return ResponseEntity.ok(cartItem);
    }
}
