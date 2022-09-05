package com.rest.app.controller;

import com.rest.app.dto.BookDTO;
import com.rest.app.dto.BookNewInfo;
import com.rest.app.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class Controller {
    private final BookService bookService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@Valid @RequestBody BookDTO bookDTO) {
        bookService.create(bookDTO);
    }

    @GetMapping(value = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO read(@RequestParam("bookId") Long bookId) {
        return bookService.read(bookId);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> list(@RequestParam("author") String author) {
        return bookService.list(author);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody BookNewInfo bookNewInfo) {
        bookService.update(bookNewInfo);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam("bookId") Long bookId) {
        bookService.delete(bookId);
    }
}
