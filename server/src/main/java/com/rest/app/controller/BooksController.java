package com.rest.app.controller;

import com.rest.app.dto.book.BookDTO;
import com.rest.app.dto.book.BookNewInfo;
import com.rest.app.manager.BookManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(bookNewInfo.getAuthor());
        bookManager.update(bookId, bookNewInfo);

    }

    public void delete(Long bookId)
    {
        System.out.println("del");
        bookManager.delete(bookId);
    }

    @DeleteMapping(value = "soft/{id}")
    public void softDelete(@PathVariable("id") Long bookId) {
        System.out.println("arch");
        bookManager.archive(bookId);
    }

}
