package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class JwtAuthenticationFilter implements Filter {

    private final JwtTokenProvider provider;
    private final CustomUserDetailsService uds;

    public JwtAuthenticationFilter(JwtTokenProvider p, CustomUserDetailsService u) {
        this.provider = p;
        this.uds = u;
    }

    @Override
    public void doFilter(
            ServletRequest req,
            ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest r = (HttpServletRequest) req;
        String h = r.getHeader("Authorization");

        if (h != null && h.startsWith("Bearer ")) {
            String token = h.substring(7);
            provider.validateToken(token);
        }

        chain.doFilter(req, res);
    }
}
