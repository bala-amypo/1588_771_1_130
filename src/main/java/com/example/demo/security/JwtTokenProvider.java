package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    private final String SECRET = "secret-key-demo";
    private final long VALIDITY = 24 * 60 * 60 * 1000; // 24 hours

    // create JWT token
    public String createToken(Long userId, String email, Set<String> roles) {
        String rolesStr = String.join(",", roles);

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("roles", rolesStr)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + VALIDITY))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    // validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    public String getEmail(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
    }

    public Set<String> getRoles(String token) {
        String roles = (String) Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().get("roles");
        return Set.of(roles.split(","));
    }

    public Long getUserId(String token) {
        Integer id = (Integer) Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().get("userId");
        return id.longValue();
    }
}
