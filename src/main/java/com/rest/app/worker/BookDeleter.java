package com.rest.app.worker;

import com.rest.app.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDeleter implements Worker<Long> {
    private final BookRepository bookRepository;
    private Long data;

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
