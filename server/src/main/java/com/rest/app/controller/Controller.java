package com.rest.app.controller;

import com.rest.app.dto.BookDTO;
import com.rest.app.dto.BookNewInfo;
import com.rest.app.manager.BookManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/books")
@RequiredArgsConstructor
public class Controller {
    private final BookManager bookManager;
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@Valid @RequestBody BookDTO bookDTO) {
        bookManager.create(bookDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO read(@PathVariable("id") Long bookId) {
        return bookManager.read(bookId);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> list() {
        return bookManager.list();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") Long bookId, @Valid @RequestBody BookNewInfo bookNewInfo) {
        bookManager.update(bookId, bookNewInfo);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long bookId) {
        bookManager.delete(bookId);
    }
}
