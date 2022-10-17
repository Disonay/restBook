package com.rest.app.security.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class LoginRequest {
    @NotNull
    private String username;

    @NotNull
    private String password;
}
