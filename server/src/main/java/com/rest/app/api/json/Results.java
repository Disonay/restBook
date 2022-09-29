package com.rest.app.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Results {
    @JsonProperty(value = "results")
    private List<Book> results;
}
