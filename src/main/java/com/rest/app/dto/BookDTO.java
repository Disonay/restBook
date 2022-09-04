package com.rest.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
}
