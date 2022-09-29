package com.rest.app.rest.dto.filter;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FilterDTO {
    @NotNull
    private String title;

    @NotNull
    private String name;

}
