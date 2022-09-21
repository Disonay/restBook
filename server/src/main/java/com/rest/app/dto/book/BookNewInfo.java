package com.rest.app.dto.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest.app.dto.author.AuthorDTO;
import lombok.Data;

import java.util.Date;

@Data
public class BookNewInfo {
    @JsonIgnore
    private Long id;

    private AuthorDTO author;

    private String title;

    private Date publicationDate;
}
