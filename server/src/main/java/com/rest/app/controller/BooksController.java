package com.rest.app.controller;

import com.rest.app.dto.book.BookDTO;
import com.rest.app.dto.book.BookNewInfo;
import com.rest.app.manager.BookManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
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

    public void delete(Long bookId) {
        bookManager.delete(bookId);
    }
}
