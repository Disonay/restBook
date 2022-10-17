package com.rest.app.security.auth;

import com.rest.app.security.configurer.AuthTokenConfigurer;
import com.rest.app.security.jwt.worker.JwtGetter;
import com.rest.app.security.jwt.worker.JwtUsernameParser;
import com.rest.app.security.jwt.validator.JwtValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class AuthTokenFilter extends OncePerRequestFilter {
    private final JwtValidator jwtValidator;
    private final JwtGetter jwtGetter;
    private final JwtUsernameParser jwtUsernameParser;
    private final AuthTokenConfigurer authConfigurer;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = jwtGetter.payload(request).execute();
            jwtValidator.validate(jwt);
            Authentication authentication = authConfigurer.
                    payload(jwtUsernameParser.payload(jwt).execute(), request).configure();
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e.getMessage(), e);
        }

        filterChain.doFilter(request, response);
    }
}
