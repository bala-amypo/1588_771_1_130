package com.example.demo.security;

import java.util.*;

public class JwtTokenProvider {

    /*
     * Token format:
     * UUID | userId | email | role1,role2
     */

    public String createToken(Long userId, String email, Set<String> roles) {
        String rolePart = (roles == null || roles.isEmpty())
                ? ""
                : String.join(",", roles);

        return UUID.randomUUID() + "|" + userId + "|" + email + "|" + rolePart;
    }

    public boolean validateToken(String token) {
        if (token == null) return false;

        String[] parts = token.split("\\|");
        return parts.length == 4;
    }

    public String getEmail(String token) {
        if (!validateToken(token)) return null;
        return token.split("\\|")[2];
    }

    public Set<String> getRoles(String token) {
        if (!validateToken(token)) return Set.of();

        String rolePart = token.split("\\|")[3];
        if (rolePart.isBlank()) return Set.of();

        return new HashSet<>(Arrays.asList(rolePart.split(",")));
    }

    public Long getUserId(String token) {
        if (!validateToken(token)) return null;
        return Long.parseLong(token.split("\\|")[1]);
    }
}
