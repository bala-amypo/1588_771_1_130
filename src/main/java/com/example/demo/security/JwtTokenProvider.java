package com.example.demo.security;

import java.util.*;

public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        return UUID.randomUUID() + "|" + userId + "|" + email;
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }

    public String getEmail(String token) {
        return token.split("\\|")[2];
    }

    public Set<String> getRoles(String token) {
        return Set.of("ADMIN");
    }

    public Long getUserId(String token) {
        return Long.parseLong(token.split("\\|")[1]);
    }
}
