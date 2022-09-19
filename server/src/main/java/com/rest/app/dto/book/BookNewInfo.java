package com.rest.app.dto.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class BookNewInfo {
    @JsonIgnore
    private Long id;

    private Long authorId;

    private String title;

    private Date publicationDate;
}
