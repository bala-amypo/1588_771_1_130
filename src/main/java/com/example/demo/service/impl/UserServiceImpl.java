package com.example.demo.service.impl;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User registerUser(RegisterRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword()); // In real project, encode password!
        user.setRoles(req.getRoles());
        return repository.save(user);
    }

    @Override
    public User loginUser(LoginRequest req) {
        Optional<User> userOpt = repository.findByUsername(req.getUsername());
        if(userOpt.isPresent() && userOpt.get().getPassword().equals(req.getPassword())) {
            return userOpt.get();
        }
        throw new RuntimeException("Invalid credentials");
    }
}
