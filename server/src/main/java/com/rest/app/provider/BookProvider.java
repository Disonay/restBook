package com.rest.app.provider;

import com.rest.app.dto.book.BookDTO;
import com.rest.app.dto.filter.FilterDTO;
import com.rest.app.entity.BookEntity;
import com.rest.app.mapper.BookMapper;
import com.rest.app.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookProvider implements Provider<BookDTO> {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDTO getEntityById(Long bookId) {
        Optional<BookEntity> optionalBook = bookRepository.findById(bookId);

        return bookMapper.bookToBookDto(optionalBook.get());
    }

    @Override
    public List<BookDTO> getAllEntities() {
        return bookMapper.bookToBookDto(bookRepository.findAllByDeletedIsFalse());
    }

    public List<BookDTO> filterBooks(FilterDTO filterDTO) {
        bookRepository.findBooksByAuthorNameAndTitle(
                filterDTO.getTitle(),
                filterDTO.getName()
        );
        return bookMapper.bookToBookDto(bookRepository.findBooksByAuthorNameAndTitle(
                filterDTO.getTitle(),
                filterDTO.getName()
        ));
    }
}
