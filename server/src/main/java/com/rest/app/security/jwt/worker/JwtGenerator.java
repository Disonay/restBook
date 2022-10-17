package com.rest.app.security.jwt.worker;

import com.rest.app.general.Worker;
import com.rest.app.security.principal.UserPrincipal;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator implements Worker<String> {
    @Value("${jwtSecret}")
    private String jwtSecret;

    private Authentication authentication;

    public Worker<String> payload(Authentication authentication) {
        this.authentication = authentication;
        return this;
    }

    @Override
    public String execute() {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
