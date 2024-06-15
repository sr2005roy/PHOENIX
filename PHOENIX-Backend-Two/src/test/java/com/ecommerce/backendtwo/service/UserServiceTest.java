package com.ecommerce.backendtwo.service;

import com.ecommerce.backendtwo.entity.User;
import com.ecommerce.backendtwo.exception.EmailAlreadyRegisteredException;
import com.ecommerce.backendtwo.exception.EmailNotRegisteredException;
import com.ecommerce.backendtwo.exception.InvalidCredentialException;
import com.ecommerce.backendtwo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private UserService underTest;
    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository);
    }

    @Test
    void loginUser_ShouldReturnCorrectUser() {
        // Given
        String email = "e1@gmail.com";
        String password = "pass";
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        User existingUser = new User(1, "Name", email, password, null);
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(existingUser));

        // When
        User returnedUser = underTest.loginUser(user);

        // Then
        assertEquals(existingUser, returnedUser);
    }

    @Test
    void loginUser_ShouldThrowIfEmailDoesNotExist() {
        // Given
        String email = "e1@gmail.com";
        User user = new User();
        user.setEmail(email);
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // When/Then
        assertThrows(EmailNotRegisteredException.class, () -> underTest.loginUser(user));

    }

    @Test
    void loginUser_ShouldThrowIfPasswordDoesNotMatch() {
        String email = "e1@gmail.com";
        String password = "pass";
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        User existingUser = new User(1, "Name", email, "wrongpass", null);
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(existingUser));

        // When/Then
        assertThrows(InvalidCredentialException.class, () -> underTest.loginUser(user));

    }

    @Test
    void registerUser_ShouldReturnCorrectUser() {
        String email = "e1@gmail.com";
        String password = "pass";
        User user = new User(1, "Name", email, password, null);
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        when(userRepository.save(user)).thenReturn(user);

        // When
        User returnedUser = underTest.registerUser(user);

        // Then
        assertEquals(user, returnedUser);
    }

    @Test
    void registerUser_ShouldSaveUser() {
        // Given
        String email = "e1@gmail.com";
        User user = new User();
        user.setEmail(email);
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // When
        underTest.registerUser(user);

        // Then
        verify(userRepository).save(user);
    }

    @Test
    void registerUser_ShouldThrowIfEmailAlreadyExists() {
        // Given
        String email = "e1@gmail.com";
        User user = new User();
        user.setEmail(email);
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        // When/Then
        assertThrows(EmailAlreadyRegisteredException.class, () -> underTest.registerUser(user));
    }
}