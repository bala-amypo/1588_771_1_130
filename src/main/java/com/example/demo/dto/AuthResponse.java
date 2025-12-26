package com.example.demo.dto;

import java.util.Set;

public class AuthResponse {
    private String email;
    private Long id;
    private String token; // you can implement JWT later
    private Set<String> roles;

    public AuthResponse(String email, Long id, String token, Set<String> roles) {
        this.email = email;
        this.id = id;
        this.token = token;
        this.roles = roles;
    }

    public String getEmail() { return email; }
    public Long getId() { return id; }
    public String getToken() { return token; }
    public Set<String> getRoles() { return roles; }
}
