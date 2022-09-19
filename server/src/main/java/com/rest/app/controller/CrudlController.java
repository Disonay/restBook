package com.rest.app.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface CrudlController<EntityDTO, EntityNewInfo> {

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void create(@Valid @RequestBody EntityDTO entityDTO);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntityDTO read(@PathVariable("id") Long entityId);

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntityDTO> list();

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void update(@PathVariable("id") Long entityId, @Valid @RequestBody EntityNewInfo entityNewInfo);

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable("id") Long entityId);
}
