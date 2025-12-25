package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter implements Filter {

    private final JwtTokenProvider provider;
    private final CustomUserDetailsService uds;

    public JwtAuthenticationFilter(JwtTokenProvider p, CustomUserDetailsService u) {
        this.provider = p;
        this.uds = u;
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String h = req.getHeader("Authorization");

        if (h != null && h.startsWith("Bearer ")) {
            String token = h.substring(7);

            if (provider.validateToken(token)) {
                String email = provider.getEmail(token);
                var ud = uds.loadUserByUsername(email);

                var auth = new UsernamePasswordAuthenticationToken(
                        ud, null, ud.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(request, response);
    }
}
