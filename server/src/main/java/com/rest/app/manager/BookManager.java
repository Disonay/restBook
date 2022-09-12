package com.rest.app.manager;

import com.rest.app.dto.BookDTO;
import com.rest.app.dto.BookNewInfo;
import com.rest.app.provider.BookProvider;
import com.rest.app.validation.ExistIdValidator;
import com.rest.app.validation.NewIdValidator;
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
    private final ExistIdValidator existIdValidator;

    public void create(BookDTO bookDTO) {
        creator.payload(bookDTO).execute();
    }

    public BookDTO read(Long bookId) {
        existIdValidator.validate(bookId);

        return provider.getBookById(bookId);
    }

    public List<BookDTO> list() {
        return provider.getAllBooks();
    }

    public void update(Long bookId, BookNewInfo bookNewInfo) {
        existIdValidator.validate(bookId);
        updater.payload(bookId, bookNewInfo).execute();
    }

    public void delete(Long bookId) {
        existIdValidator.validate(bookId);
        deleter.payload(bookId).execute();
    }
}
