// package com.example.demo.security;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;
// import java.io.IOException;

// @Component
// public class JwtAuthenticationFilter extends OncePerRequestFilter {
//     private final JwtTokenProvider jwtTokenProvider;
//     private final CustomUserDetailsService userDetailsService;
    
//     public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, 
//                                   CustomUserDetailsService userDetailsService) {
//         this.jwtTokenProvider = jwtTokenProvider;
//         this.userDetailsService = userDetailsService;
//     }
    
//     @Override
//     protected void doFilterInternal(HttpServletRequest request, 
//                                    HttpServletResponse response, 
//                                    FilterChain filterChain) throws ServletException, IOException {
//         String token = resolveToken(request);
        
//         if (token != null && jwtTokenProvider.validateToken(token)) {
//             String email = jwtTokenProvider.getEmail(token);
//             UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            
//             if (userDetails != null) {
//                 UsernamePasswordAuthenticationToken auth = 
//                     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                 auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(auth);
//             }
//         }
        
//         filterChain.doFilter(request, response);
//     }
    
//     private String resolveToken(HttpServletRequest request) {
//         String bearerToken = request.getHeader("Authorization");
//         if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//             return bearerToken.substring(7);
//         }
//         return null;
//     }
// }

package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(
            JwtTokenProvider jwtTokenProvider,
            CustomUserDetailsService userDetailsService
    ) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    // 🔴 IMPORTANT: skip auth & swagger endpoints
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.startsWith("/api/auth/")
            || path.startsWith("/swagger-ui/")
            || path.startsWith("/v3/api-docs");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            if (jwtTokenProvider.validateToken(token)) {

                String email = jwtTokenProvider.getEmail(token);
                UserDetails userDetails =
                        userDetailsService.loadUserByUsername(email);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
