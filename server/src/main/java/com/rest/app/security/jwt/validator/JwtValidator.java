package com.rest.app.security.jwt.validator;

import com.rest.app.general.Validator;
import com.rest.app.security.jwt.worker.JwtUsernameParser;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator implements Validator<String> {
    @Value("${jwtSecret}")
    private String jwtSecret;

    private static final Logger logger = LoggerFactory.getLogger(JwtUsernameParser.class);

    @Override
    public void validate(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
    }
}
