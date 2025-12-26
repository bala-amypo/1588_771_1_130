package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwt;

    public AuthController(UserRepository r, PasswordEncoder e, JwtTokenProvider j) {
        this.repo = r;
        this.encoder = e;
        this.jwt = j;
    }

    public ResponseEntity<?> register(RegisterRequest req) {
        if (repo.findByEmail(req.getEmail()).isPresent())
            return ResponseEntity.status(409).build();

        User u = User.builder()
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .roles(req.getRoles())
                .name(req.getName())
                .build();

        repo.save(u);
        String token = jwt.createToken(u.getId(), u.getEmail(), u.getRoles());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    public ResponseEntity<?> login(AuthRequest req) {
        Optional<User> u = repo.findByEmail(req.getEmail());
        if (u.isEmpty() || !encoder.matches(req.getPassword(), u.get().getPassword()))
            return ResponseEntity.status(401).build();

        String token = jwt.createToken(
                u.get().getId(),
                u.get().getEmail(),
                u.get().getRoles());

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
