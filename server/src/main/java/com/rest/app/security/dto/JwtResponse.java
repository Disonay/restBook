package com.rest.app.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@AllArgsConstructor
@Data
public class JwtResponse {
    private String token;
    private String username;
    private Collection<? extends GrantedAuthority> roles;
}
