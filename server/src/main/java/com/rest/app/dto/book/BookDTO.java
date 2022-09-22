package com.rest.app.dto.book;

import com.rest.app.dto.author.AuthorDTO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BookDTO {
    private Long id;

    @NotNull
    private AuthorDTO author;

    @NotNull
    private String title;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date publicationDate;

}
