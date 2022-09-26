package com.rest.app.controller;

import com.rest.app.dto.book.BookDTO;
import com.rest.app.dto.book.BookNewInfo;
import com.rest.app.dto.filter.FilterDTO;
import com.rest.app.manager.BookManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BooksController implements CrudlController<BookDTO, BookNewInfo>  {
    private final BookManager bookManager;

    public void create(BookDTO bookDTO) {
        bookManager.create(bookDTO);
    }

    public BookDTO read(Long bookId) {
        return bookManager.read(bookId);
    }

    public List<BookDTO> list() {
        return bookManager.list();
    }


    public void update(Long bookId, BookNewInfo bookNewInfo) {
        bookManager.update(bookId, bookNewInfo);

    }

    public void delete(Long bookId)
    {
        bookManager.delete(bookId);
    }

    @DeleteMapping(value = "soft/{id}")
    public void softDelete(@PathVariable("id") Long bookId) {
        bookManager.archive(bookId);
    }

    @PostMapping(value = "filter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> filter(@Valid @RequestBody FilterDTO filterDTO) {
        return bookManager.filter(filterDTO);
    }

    @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> search(@RequestParam("input") String input) {
        return bookManager.search(input);
    }

}
