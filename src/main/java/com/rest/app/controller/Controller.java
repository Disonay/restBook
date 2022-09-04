package com.rest.app.controller;

import com.rest.app.dto.BookDTO;
import com.rest.app.dto.UpdatedBookDTO;
import com.rest.app.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class Controller {

    private final Service service;
    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public void create(@Valid @RequestBody BookDTO bookDTO) {
        service.create(bookDTO);
    }

    @GetMapping(value = "/read", produces = "application/json")
    public BookDTO read(@RequestParam("bookId") Long bookId) {
        return service.read(bookId);
    }

    @GetMapping(value = "/list", produces = "application/json")
    public List<BookDTO> list(@RequestParam("author") String author) {
        return service.list(author);
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public void update(@Valid @RequestBody UpdatedBookDTO updatedBookDTO) {
        service.update(updatedBookDTO);
    }

    @GetMapping(value = "/clear")
    public void clear() {
        service.clear();
    }
}
