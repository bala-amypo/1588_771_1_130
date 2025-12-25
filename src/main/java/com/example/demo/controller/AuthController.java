package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;

import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwt;

    public AuthController(UserRepository r, PasswordEncoder e, JwtTokenProvider j) {
        this.repo = r;
        this.encoder = e;
        this.jwt = j;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {

        if (repo.findByEmail(req.getEmail()).isPresent())
            return ResponseEntity.status(409).build();

        User u = User.builder()
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .roles(req.getRoles())
                .name(req.getName())
                .build();

        repo.save(u);

        String t = jwt.createToken(u.getId(), u.getEmail(), u.getRoles());
        return ResponseEntity.ok(new AuthResponse(t));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {

        return repo.findByEmail(req.getEmail())
                .filter(u -> encoder.matches(req.getPassword(), u.getPassword()))
                .map(u -> ResponseEntity.ok(
                        new AuthResponse(jwt.createToken(
                                u.getId(), u.getEmail(), u.getRoles()))))
                .orElse(ResponseEntity.status(401).build());
    }
}
