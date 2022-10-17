package com.rest.app.security.configurer;

import com.rest.app.general.Configurer;
import com.rest.app.security.dto.JwtResponse;
import com.rest.app.security.jwt.worker.JwtGenerator;
import com.rest.app.security.principal.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConfigureJwtResponse implements Configurer<JwtResponse> {
    private final JwtGenerator jwtGenerator;

    private Authentication authentication;

    public Configurer<JwtResponse> payload(Authentication authentication) {
        this.authentication = authentication;

        return this;
    }

    public JwtResponse configure() {
        String jwt = jwtGenerator.payload(authentication).execute();
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();

        return new JwtResponse(jwt,
                userDetails.getUsername(),
                userDetails.getAuthorities());
    }
}
