package com.rest.app.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class BookDTO {
    @NotNull
    private Long id;

    @NotNull
    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][.] [А-Я][.]")
    private String author;

    @NotNull
    private String name;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date publicationDate;
}
