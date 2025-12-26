package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String email;
    private Long id;
    private String token; // optional, just placeholder
    private Set<String> roles;
}
