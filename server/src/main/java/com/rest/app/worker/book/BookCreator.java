package com.rest.app.worker.book;

import com.rest.app.dto.book.BookDTO;
import com.rest.app.mapper.BookMapper;
import com.rest.app.repository.BookRepository;
import com.rest.app.worker.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookCreator implements Worker<BookDTO> {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private BookDTO bookDTO;

    public BookCreator payload(BookDTO data) {
        this.bookDTO = data;

        return this;
    }

    @Override
    public void execute() {
        bookRepository.save(bookMapper.bookDtoToBook(bookDTO));
    }
}