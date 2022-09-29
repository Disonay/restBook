package com.rest.app.rest.dto.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest.app.rest.dto.author.AuthorDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
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
