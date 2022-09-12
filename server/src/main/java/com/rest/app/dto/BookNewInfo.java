package com.rest.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class BookNewInfo {
    @JsonIgnore
    private Long id;

    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][.] [А-Я][.]")
    private String author;

    private String name;

    private Date publicationDate;
}
