package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.LoginRequest;

import java.util.List;

public interface UserService {

    User registerUser(RegisterRequest req);

    User loginUser(LoginRequest req);
    
}
