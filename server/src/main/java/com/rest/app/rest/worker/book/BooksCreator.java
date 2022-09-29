package com.rest.app.rest.worker.book;

import com.rest.app.rest.dto.book.BookDTO;
import com.rest.app.rest.mapper.BookMapper;
import com.rest.app.rest.repository.book.BookRepository;
import com.rest.app.general.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BooksCreator implements Worker {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private List<BookDTO> bookDTO;

    public Worker payload(List<BookDTO> data) {
        this.bookDTO = data;

        return this;
    }

    @Override
    public void execute() {
        bookRepository.saveAll(bookMapper.bookDtoToBook(bookDTO));
    }
}
