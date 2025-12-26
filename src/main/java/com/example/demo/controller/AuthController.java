package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    public AuthController(UserService userService, JwtTokenProvider tokenProvider) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
        User u = userService.register(user);
        String token = tokenProvider.createToken(u.getId(), u.getEmail(), u.getRoles());
        return ResponseEntity.ok(new AuthResponse(token, u.getId(), u.getEmail(), u.getRoles()));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody User user) {
        User u = userService.authenticate(user.getEmail(), user.getPassword());
        String token = tokenProvider.createToken(u.getId(), u.getEmail(), u.getRoles());
        return ResponseEntity.ok(new AuthResponse(token, u.getId(), u.getEmail(), u.getRoles()));
    }
}
