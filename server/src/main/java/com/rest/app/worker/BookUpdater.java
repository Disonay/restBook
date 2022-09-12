package com.rest.app.worker;

import com.rest.app.dto.BookNewInfo;
import com.rest.app.entity.BookEntity;
import com.rest.app.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookUpdater implements Worker<BookNewInfo> {
    private final BookRepository bookRepository;
    private Long bookId;
    private BookNewInfo bookNewInfo;


    public Worker<BookNewInfo> payload(Long bookId, BookNewInfo data) {
        this.bookId = bookId;
        this.bookNewInfo = data;

        return this;
    }

    @Override
    public void execute() {
        Optional<BookEntity> optionalBook = bookRepository.findById(bookId);
        BookEntity updatebleBook = optionalBook.get();

        if (!Objects.isNull(bookNewInfo.getAuthor())) {
            updatebleBook.setAuthor(bookNewInfo.getAuthor());
        }
        if (!Objects.isNull(bookNewInfo.getName())) {
            updatebleBook.setName(bookNewInfo.getName());
        }
        if (!Objects.isNull(bookNewInfo.getPublicationDate())) {
            updatebleBook.setPublicationDate(bookNewInfo.getPublicationDate());
        }

        bookRepository.save(updatebleBook);
    }
}
