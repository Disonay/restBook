package com.rest.app.rest.worker.book;

import com.rest.app.rest.dto.book.BookDTO;
import com.rest.app.rest.mapper.BookMapper;
import com.rest.app.rest.repository.book.BookRepository;
import com.rest.app.general.VoidWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookCreator implements VoidWorker {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private BookDTO bookDTO;

    public VoidWorker payload(BookDTO data) {
        this.bookDTO = data;

        return this;
    }

    @Override
    public void execute() {
        bookRepository.save(bookMapper.bookDtoToBook(bookDTO));
    }
}
