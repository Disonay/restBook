package com.rest.app.worker;

import com.rest.app.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookDeleter extends Worker<Long> {
    public BookDeleter(BookRepository bookRepository) {
        super(bookRepository);
    }

    @Override
    public BookDeleter payload(Long data) {
        this.data = data;

        return this;
    }

    @Override
    public void execute() {
        bookRepository.deleteById(data);
    }
}
