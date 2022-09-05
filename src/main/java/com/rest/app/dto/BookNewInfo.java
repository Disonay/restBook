package com.rest.app.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class BookNewInfo {
    @NotNull
    private Long id;

    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][.] [А-Я][.]")
    private String newAuthor;

    private String newName;

    private Date newPublicationDate;
}
