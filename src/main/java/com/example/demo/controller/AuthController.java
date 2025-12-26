package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Authentication endpoints")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwt;

    public AuthController(UserService userService, JwtTokenProvider jwt) {
        this.userService = userService;
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        User user = userService.loginUser(request);
        String token = jwt.createToken(user.getId(), user.getEmail(), user.getRoles());
        AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRoles());
        return ResponseEntity.ok(response);
    }
}
