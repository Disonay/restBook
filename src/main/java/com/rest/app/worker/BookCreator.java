package com.rest.app.worker;

import com.rest.app.dto.BookDTO;
import com.rest.app.mapper.BookMapper;
import com.rest.app.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookCreator extends Worker<BookDTO> {
    public BookCreator(BookRepository bookRepository) {
        super(bookRepository);
    }

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
