package com.felixDev.movieFliex.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenConfig tokenConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse reponse, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (Strings.isNotEmpty(authHeader) && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring("Bearer ".length());
            Optional<JWTUserData> optionalJWTUserData = tokenConfig.verifyToken(token);
            if (optionalJWTUserData.isPresent()) {
                JWTUserData userData = optionalJWTUserData.get();

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userData, null,null);
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

            filterChain.doFilter(request,reponse);
        }else{
            filterChain.doFilter(request,reponse);
        }
    }

}
