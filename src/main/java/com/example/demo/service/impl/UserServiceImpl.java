package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String registerUser(RegisterRequest request) {
        return "User Registered Successfully";
    }
    @Override
    public AuthResponse loginUser(AuthRequest request) {
        String token="sample-jwt-token";
        return new AuthResponse(token);
    }
}
