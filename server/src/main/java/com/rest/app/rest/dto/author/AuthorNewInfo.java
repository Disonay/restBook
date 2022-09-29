package com.rest.app.rest.dto.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class AuthorNewInfo {
    @JsonIgnore
    private Long id;

    private String surname;

    private String name;

    private String middleName;
}
