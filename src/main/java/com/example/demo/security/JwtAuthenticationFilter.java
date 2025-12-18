// @Component
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     @Autowired
//     private JwtTokenProvider jwtProvider;

//     @Override
//     protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
//             throws ServletException, IOException {

//         String header = req.getHeader("Authorization");
//         if (header != null && header.startsWith("Bearer ")) {
//             jwtProvider.validateToken(header.substring(7));
//         }
//         chain.doFilter(req, res);
//     }
// }
