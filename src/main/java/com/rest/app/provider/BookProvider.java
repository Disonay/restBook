package com.rest.app.provider;

import com.rest.app.dto.BookDTO;
import com.rest.app.entity.BookEntity;
import com.rest.app.mapper.BookMapper;
import com.rest.app.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookProvider {
    private final BookRepository bookRepository;

    public BookDTO getBookById(Long bookId) {
        Optional<BookEntity> optionalBook = bookRepository.findById(bookId);

        return BookMapper.INSTANCE.bookToBookDto(optionalBook.get());
    }

    public List<BookDTO> getBooksByAuthor(String author) {
        return BookMapper.INSTANCE.bookToBookDto(bookRepository.findBookEntitiesByAuthor(author));
    }
}
