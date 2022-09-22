package com.rest.app.manager;

import com.rest.app.dto.book.BookDTO;
import com.rest.app.dto.book.BookNewInfo;
import com.rest.app.provider.BookProvider;
import com.rest.app.validation.author.ExistAuthorValidator;
import com.rest.app.validation.book.ExistBookIdValidator;
import com.rest.app.worker.book.BookArchiver;
import com.rest.app.worker.book.BookCreator;
import com.rest.app.worker.book.BookDeleter;
import com.rest.app.worker.book.BookUpdater;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookManager implements Manager<BookDTO, BookNewInfo> {
    private final BookCreator creator;
    private final BookDeleter deleter;
    private final BookUpdater updater;
    private final BookProvider provider;

    private final BookArchiver archiver;
    private final ExistBookIdValidator existBookIdValidator;

    private final ExistAuthorValidator existAuthorValidator;

    @Override
    public void create(BookDTO bookDTO) {
        existAuthorValidator.validate(bookDTO.getAuthor());
        creator.payload(bookDTO).execute();
    }

    @Override
    public BookDTO read(Long bookId) {
        existBookIdValidator.validate(bookId);

        return provider.getEntityById(bookId);
    }

    @Override
    public List<BookDTO> list() {
        return provider.getAllEntities();
    }

    @Override
    public void update(Long bookId, BookNewInfo bookNewInfo) {
        existBookIdValidator.validate(bookId);
        existAuthorValidator.validate(bookNewInfo.getAuthor());

        updater.payload(bookId, bookNewInfo).execute();
    }

    @Override
    public void delete(Long bookId) {
        existBookIdValidator.validate(bookId);
        deleter.payload(bookId).execute();
    }

    public void archive(Long bookId) {
        existBookIdValidator.validate(bookId);
        archiver.payload(bookId).execute();
    }
}
