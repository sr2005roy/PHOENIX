package com.ecommerce.backendtwo.controller;

import com.ecommerce.backendtwo.entity.User;
import com.ecommerce.backendtwo.exception.FailedRequestException;
import com.ecommerce.backendtwo.service.CartService;
import com.ecommerce.backendtwo.service.JwtService;
import com.ecommerce.backendtwo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {
    private AuthController underTest;
    @Mock private UserService userService;
    @Mock private CartService cartService;
    @Mock private JwtService jwtService;

    @BeforeEach
    void setUp() {
        underTest = new AuthController(userService, cartService, jwtService);
    }

    @Test
    void registerUser_ShouldSaveUser() {
        // Given
        User user = new User();
        when(userService.registerUser(user)).thenReturn(new User());

        // When
        underTest.registerUser(user);

        // Then
        verify(userService).registerUser(user);
    }

    @Test
    void registerUser_ShouldCreateCartForUser() {
        // Given
        User user = new User();
        when(userService.registerUser(user)).thenReturn(new User());

        // When
        underTest.registerUser(user);

        // Then
        verify(cartService).addCartOfUser(user);
    }

    @Test
    void registerUser_ShouldThrowIfFailedToRegister() {
        // Given
        User user = new User();
        when(userService.registerUser(user)).thenReturn(null);

        // When/Then
        assertThrows(FailedRequestException.class, () -> underTest.registerUser(user));
    }

    @Test
    void loginUser_ShouldCallLoginUser() {
        // Given
        User user = new User();
        User existingUser = new User();
        when(userService.loginUser(user)).thenReturn(existingUser);

        // When
        underTest.loginUser(user);

        // Then
        verify(userService).loginUser(user);
    }

    @Test
    void loginUser_ShouldAddJwtTokenOfUser() {
        // Given
        String token = "jwt-token";
        User user = new User();
        User existingUser = new User();
        when(userService.loginUser(user)).thenReturn(existingUser);
        when(jwtService.encode(existingUser)).thenReturn(token);

        // When
        ResponseEntity<User> response = underTest.loginUser(user);

        // Then
        assert (response.getBody().getToken().equals(token));
    }

    @Test
    void loginUser_ShouldReturnUser() {
        // Given
        String token = "jwt-token";
        User user = new User();
        User existingUser = new User();
        existingUser.setToken(token);
        when(userService.loginUser(user)).thenReturn(existingUser);
        when(jwtService.encode(existingUser)).thenReturn(token);

        // When
        ResponseEntity<User> response = underTest.loginUser(user);

        // Then
        assert(Objects.equals(response.getBody(), existingUser));
    }

    @Test
    void validateUser_ShouldReturnUser() {
        // Given
        String token = "jwt-token";
        User user = new User();
        when(jwtService.decode(token)).thenReturn(user);

        // When
        ResponseEntity<User> response = underTest.validateUser(token);

        // Then
        assert(Objects.equals(response.getBody(), user));
    }
}