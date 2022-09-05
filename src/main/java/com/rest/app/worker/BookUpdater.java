package com.rest.app.worker;

import com.rest.app.dto.BookNewInfo;
import com.rest.app.entity.BookEntity;
import com.rest.app.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class BookUpdater extends Worker<BookNewInfo>{
    public BookUpdater(BookRepository bookRepository) {
        super(bookRepository);
    }

    @Override
    public Worker<BookNewInfo> payload(BookNewInfo data) {
        this.data = data;

        return this;
    }

    @Override
    public void execute() {
        Optional<BookEntity> optionalBook = bookRepository.findById(data.getId());
        BookEntity updatebleBook = optionalBook.get();

        if (!Objects.isNull(data.getNewAuthor())) {
            updatebleBook.setAuthor(data.getNewAuthor());
        }
        if (!Objects.isNull(data.getNewName())) {
            updatebleBook.setName(data.getNewName());
        }
        if (!Objects.isNull(data.getNewPublicationDate())) {
            updatebleBook.setPublicationDate(data.getNewPublicationDate());
        }

        bookRepository.save(updatebleBook);
    }
}
