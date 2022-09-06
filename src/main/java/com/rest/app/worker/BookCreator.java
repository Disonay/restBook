package com.rest.app.worker;

import com.rest.app.dto.BookDTO;
import com.rest.app.mapper.BookMapper;
import com.rest.app.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookCreator implements Worker<BookDTO> {
    private final BookRepository bookRepository;
    private BookDTO data;

    @Override
    public BookCreator payload(BookDTO data) {
        this.data = data;

        return this;
    }

    @Override
    public void execute() {
        bookRepository.save(BookMapper.INSTANCE.bookDtoToBook(data));
    }
}
