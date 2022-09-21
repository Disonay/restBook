package com.rest.app.worker.book;

import com.rest.app.dto.book.BookNewInfo;
import com.rest.app.entity.BookEntity;
import com.rest.app.mapper.AuthorMapper;
import com.rest.app.repository.BookRepository;
import com.rest.app.worker.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookUpdater implements Worker {
    private final BookRepository bookRepository;
    private final AuthorMapper authorMapper;
    private Long bookId;
    private BookNewInfo bookNewInfo;


    public Worker payload(Long bookId, BookNewInfo data) {
        this.bookId = bookId;
        this.bookNewInfo = data;

        return this;
    }

    @Override
    public void execute() {
        Optional<BookEntity> optionalBook = bookRepository.findById(bookId);
        BookEntity updatebleBook = optionalBook.get();

        if (!Objects.isNull(bookNewInfo.getAuthor())) {
            updatebleBook.setAuthor(authorMapper.authorDtoToAuthor(bookNewInfo.getAuthor()));
        }
        if (!Objects.isNull(bookNewInfo.getTitle())) {
            updatebleBook.setTitle(bookNewInfo.getTitle());
        }
        if (!Objects.isNull(bookNewInfo.getPublicationDate())) {
            updatebleBook.setPublicationDate(bookNewInfo.getPublicationDate());
        }

        bookRepository.save(updatebleBook);
    }
}
