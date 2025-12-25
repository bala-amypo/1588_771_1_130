package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest req) {

        // Build the user correctly
        User user = User.builder()
                .username(req.getUsername())  // corrected
                .email(req.getEmail())
                .password(req.getPassword())
                .role("USER")  // single role field
                .build();

        userService.registerUser(user);

        return ResponseEntity.ok("User registered: " + user.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody RegisterRequest req) {
        // Just an example
        boolean success = userService.login(req.getUsername(), req.getPassword());
        if (success) {
            return ResponseEntity.ok("Login successful for: " + req.getUsername());
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
