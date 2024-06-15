package com.ecommerce.backendtwo.controller;

import com.ecommerce.backendtwo.entity.User;
import com.ecommerce.backendtwo.exception.FailedRequestException;
import com.ecommerce.backendtwo.service.CartService;
import com.ecommerce.backendtwo.service.JwtService;
import com.ecommerce.backendtwo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        if (newUser == null) throw new FailedRequestException("Failed to register user");
        cartService.addCartOfUser(newUser);
        newUser.setToken(jwtService.encode(newUser));
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User existingUser = userService.loginUser(user);
        if (existingUser == null) throw new FailedRequestException("Failed to login user");
        existingUser.setToken(jwtService.encode(existingUser));
        return ResponseEntity.ok(existingUser);
    }

    @GetMapping("/validate")
    public ResponseEntity<User> validateUser(@RequestHeader(name = "Authorization") String token) {
        User user = jwtService.decode(token);
        return ResponseEntity.ok(user);
    }
}
