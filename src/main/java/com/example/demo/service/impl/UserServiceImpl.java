package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    @Override
    public User registerUser(RegisterRequest req) {
        User u = User.builder()
                .username(req.getUsername())
                .email(req.getEmail())
                .password(req.getPassword())
                .roles(req.getRoles())
                .build();
        return repo.save(u);
    }

    @Override
    public User loginUser(LoginRequest req) {
        return repo.findByEmail(req.getEmail())
                   .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
