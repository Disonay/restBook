package com.rest.app.rest.worker.book;

import com.rest.app.rest.dto.book.BookDTO;
import com.rest.app.rest.mapper.BookMapper;
import com.rest.app.rest.repository.book.BookRepository;
import com.rest.app.general.VoidWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BooksCreator implements VoidWorker {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private List<BookDTO> bookDTO;

    public VoidWorker payload(List<BookDTO> data) {
        this.bookDTO = data;

        return this;
    }

    @Override
    public void execute() {
        bookRepository.saveAll(bookMapper.bookDtoToBook(bookDTO));
    }
}
