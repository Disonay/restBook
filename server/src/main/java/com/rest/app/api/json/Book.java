package com.rest.app.api.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "authors")
    private List<String> authors;

    @JsonProperty(value = "issued")
    private Date publicationDate;
}
