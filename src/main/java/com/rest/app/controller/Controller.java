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
@RequestMapping("/book")
@RequiredArgsConstructor
public class Controller {
    private final BookManager bookManager;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@Valid @RequestBody BookDTO bookDTO) {
        bookManager.create(bookDTO);
    }

    @GetMapping(value = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO read(@RequestParam("bookId") Long bookId) {
        return bookManager.read(bookId);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> list(@RequestParam("author") String author) {
        return bookManager.list(author);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody BookNewInfo bookNewInfo) {
        bookManager.update(bookNewInfo);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam("bookId") Long bookId) {
        bookManager.delete(bookId);
    }
}
