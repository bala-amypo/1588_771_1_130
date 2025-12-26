// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;
// import java.security.Key;
// import java.util.Date;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// @Component
// public class JwtTokenProvider {
//     private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//     private final long validityInMilliseconds = 3600000; // 1h
    
//     public String createToken(Long userId, String email, Set<String> roles) {
//         Claims claims = Jwts.claims().setSubject(email);
//         claims.put("userId", userId);
//         claims.put("roles", roles);
        
//         Date now = new Date();
//         Date validity = new Date(now.getTime() + validityInMilliseconds);
        
//         return Jwts.builder()
//             .setClaims(claims)
//             .setIssuedAt(now)
//             .setExpiration(validity)
//             .signWith(key)
//             .compact();
//     }
    
//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException e) {
//             return false;
//         }
//     }
    
//     public String getEmail(String token) {
//         return Jwts.parserBuilder().setSigningKey(key).build()
//             .parseClaimsJws(token).getBody().getSubject();
//     }
    
//     @SuppressWarnings("unchecked")
//     public Set<String> getRoles(String token) {
//         Object roles = Jwts.parserBuilder().setSigningKey(key).build()
//             .parseClaimsJws(token).getBody().get("roles");
//         if (roles instanceof List) {
//             return new HashSet<>((List<String>) roles);
//         }
//         return (Set<String>) roles;
//     }
    
//     public Long getUserId(String token) {
//         return Long.valueOf(Jwts.parserBuilder().setSigningKey(key).build()
//             .parseClaimsJws(token).getBody().get("userId").toString());
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private static final String SECRET_KEY = "my-super-secret-key-for-jwt-demo-application"; // min 32 chars
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Generate token
    public String createToken(Long id, String email, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("roles", roles);
        claims.put("id", id);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract email
    public String getEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
