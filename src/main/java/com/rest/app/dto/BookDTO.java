package com.rest.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookDTO {
    private Long id;
    private String author;
    private String name;
    private Date date;
}
