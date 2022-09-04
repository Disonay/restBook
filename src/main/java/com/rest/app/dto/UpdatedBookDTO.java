package com.rest.app.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class UpdatedBookDTO {
    @NotNull
    private Long id;

    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][.] [А-Я][.]")
    private String newAuthor;

    private String newName;

    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date newPublicationDate;
}
