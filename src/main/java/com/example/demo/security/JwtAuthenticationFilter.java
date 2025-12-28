package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtAuthenticationFilter implements Filter {

    private final JwtTokenProvider provider;
    private final CustomUserDetailsService uds;

    public JwtAuthenticationFilter(JwtTokenProvider provider,
                                   CustomUserDetailsService uds) {
        this.provider = provider;
        this.uds = uds;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            provider.validateToken(header.substring(7));
        }
        chain.doFilter(req, res);
    }
}
