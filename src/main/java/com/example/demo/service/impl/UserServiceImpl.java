package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserServiceImpl {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a new user. Throws IllegalArgumentException if email already exists.
     */
    public User registerUser(RegisterRequest req) {
        Optional<User> existing = userRepo.findByEmail(req.getEmail());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = User.builder()
                .email(req.getEmail())                  // matches DTO
                .name(req.getName())                    // optional display name
                .password(passwordEncoder.encode(req.getPassword()))
                .roles(req.getRoles())
                .build();

        return userRepo.save(user);
    }

    /**
     * Loads user by email (used by authentication).
     */
    public User loadUserByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
