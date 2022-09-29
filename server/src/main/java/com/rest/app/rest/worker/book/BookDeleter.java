package com.rest.app.rest.worker.book;

import com.rest.app.rest.repository.book.BookRepository;
import com.rest.app.general.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDeleter implements Worker {
    private final BookRepository bookRepository;
    private Long id;

    public BookDeleter payload(Long data) {
        this.id = data;

        return this;
    }

    @Override
    public void execute() {
        bookRepository.deleteById(id);
    }
}
