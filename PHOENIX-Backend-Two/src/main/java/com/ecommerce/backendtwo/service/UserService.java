package com.ecommerce.backendtwo.service;

import com.ecommerce.backendtwo.entity.User;
import com.ecommerce.backendtwo.exception.EmailAlreadyRegisteredException;
import com.ecommerce.backendtwo.exception.EmailNotRegisteredException;
import com.ecommerce.backendtwo.exception.InvalidCredentialException;
import com.ecommerce.backendtwo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository repository;

    public User loginUser(User user) {
        User existingUser = repository.findByEmail(user.getEmail()).orElse(null);
        if (existingUser == null)
            throw new EmailNotRegisteredException();
        if (!existingUser.getPassword().equals(user.getPassword()))
            throw new InvalidCredentialException();
        return existingUser;
    }

    public User registerUser(User user) {
        User existingUser = repository.findByEmail(user.getEmail()).orElse(null);
        if (existingUser != null) throw new EmailAlreadyRegisteredException();
        return repository.save(user);
    }

}
