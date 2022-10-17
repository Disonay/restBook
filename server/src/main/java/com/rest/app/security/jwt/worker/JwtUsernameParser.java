package com.rest.app.security.jwt.worker;

import com.rest.app.general.Worker;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUsernameParser implements Worker<String> {
    @Value("${jwtSecret}")
    private String jwtSecret;

    private String token;

    public Worker<String> payload(String token) {
        this.token = token;
        return this;
    }

    @Override
    public String execute() {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
}
