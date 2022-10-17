package com.rest.app.security.configurer;

import com.rest.app.general.Configurer;
import com.rest.app.security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@RequiredArgsConstructor
public class AuthTokenConfigurer implements Configurer<UsernamePasswordAuthenticationToken> {
    private final UserDetailsServiceImpl userDetailsService;
    private String username;
    private HttpServletRequest request;

    public Configurer<UsernamePasswordAuthenticationToken> payload(String username, HttpServletRequest request) {
        this.username = username;
        this.request = request;

        return this;
    }

    public UsernamePasswordAuthenticationToken configure() {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities());

        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        return authenticationToken;
    }
}
