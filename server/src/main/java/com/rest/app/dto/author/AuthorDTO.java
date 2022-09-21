package com.rest.app.dto.author;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthorDTO {
    private Long id;

    @NotNull
    private String surname;

    @NotNull
    private String name;

    @NotNull
    private String middleName;
}
