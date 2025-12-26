package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody User user) {
        User saved = userService.register(user);
        return new AuthResponse(saved.getEmail(), saved.getId(), "dummy-token", saved.getRoles());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody User user) {
        User authenticated = userService.authenticate(user.getEmail(), user.getPassword());
        return new AuthResponse(authenticated.getEmail(), authenticated.getId(), "dummy-token", authenticated.getRoles());
    }
}
