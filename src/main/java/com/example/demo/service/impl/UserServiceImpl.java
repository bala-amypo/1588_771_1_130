package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        // Save user to DB
        userRepository.save(user);
    }

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) return false;

        // Simple password check (in production, use BCrypt)
        return user.getPassword().equals(password);
    }
}
