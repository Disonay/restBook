package com.rest.app.service;

import com.rest.app.dto.BookDTO;
import com.rest.app.dto.BookNewInfo;
import com.rest.app.provider.BookProvider;
import com.rest.app.validation.BookAlreadyExistValidator;
import com.rest.app.worker.BookCreator;
import com.rest.app.worker.BookDeleter;
import com.rest.app.worker.BookUpdater;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookManager {
    private final BookCreator creator;
    private final BookDeleter deleter;
    private final BookUpdater updater;
    private final BookProvider provider;

    private final BookAlreadyExistValidator bookAlreadyExistValidator;

    public void create(BookDTO bookDTO) {
        bookAlreadyExistValidator.validate(bookDTO.getId());
        creator.payload(bookDTO).execute();
    }

    public BookDTO read(Long bookId) {
       return provider.getBookById(bookId);
    }

    public List<BookDTO> list(String author) {
        return provider.getBooksByAuthor(author);
    }

    public void update(BookNewInfo bookNewInfo) {
        updater.payload(bookNewInfo).execute();
    }

    public void delete(Long bookId) {
        deleter.payload(bookId).execute();
    }
}
