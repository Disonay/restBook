package com.rest.app.rest.worker.book;

import com.rest.app.rest.repository.book.BookRepository;
import com.rest.app.general.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookArchiver implements Worker {

    private final BookRepository bookRepository;
    private Long id;

    public Worker payload(Long data) {
        this.id = data;

        return this;
    }

    @Override
    public void execute() {
        bookRepository.softDeleteById(id);
    }
}
