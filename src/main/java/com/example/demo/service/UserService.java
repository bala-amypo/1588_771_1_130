package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.model.User;

public interface UserService {
    void registerUser(User user);
    boolean loginUser(LoginRequest loginRequest);
}
