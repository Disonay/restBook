package com.rest.app.rest.dto.author;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class AuthorDTO {
    private Long id;

    @NonNull
    private String surname;

    @NonNull
    private String name;

    private String middleName;
}
