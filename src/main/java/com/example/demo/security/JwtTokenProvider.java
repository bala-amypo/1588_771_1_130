// @Component
// public class JwtTokenProvider {

//     private final String SECRET = "secret-key-123456";

//     public String createToken(Long userId, String email, Set<String> roles) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("userId", userId)
//                 .claim("roles", roles)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + 86400000))
//                 .signWith(SignatureAlgorithm.HS256, SECRET)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
//         return true;
//     }

//     public String getEmail(String token) {
//         return Jwts.parser().setSigningKey(SECRET)
//                 .parseClaimsJws(token).getBody().getSubject();
//     }
// }
