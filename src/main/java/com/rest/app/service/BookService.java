package com.rest.app.service;

import com.rest.app.dto.BookDTO;
import com.rest.app.dto.BookNewInfo;
import com.rest.app.entity.BookEntity;
import com.rest.app.exception.BookAlreadyExistException;
import com.rest.app.exception.BookNotFoundException;
import com.rest.app.mapper.BookMapper;
import com.rest.app.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void create(BookDTO bookDTO) {
        if (bookRepository.findById(bookDTO.getId()).isPresent()) {
            throw new BookAlreadyExistException();
        }

        bookRepository.save(BookMapper.INSTANCE.bookDtoToBook(bookDTO));
    }

    public BookDTO read(Long bookId) {
        Optional<BookEntity> optionalBook = bookRepository.findById(bookId);

        if (!optionalBook.isPresent()) {
            throw new BookNotFoundException();
        }

        return BookMapper.INSTANCE.bookToBookDto(optionalBook.get());
    }

    public List<BookDTO> list(String author) {
        return BookMapper.INSTANCE.bookToBookDto(bookRepository.findBookEntitiesByAuthor(author));
    }

    public void update(BookNewInfo bookNewInfo) {
        Optional<BookEntity> optionalBook = bookRepository.findById(bookNewInfo.getId());

        if (!optionalBook.isPresent()) {
            throw new BookNotFoundException();
        }

        BookEntity updatebleBook = optionalBook.get();

        if (!Objects.isNull(bookNewInfo.getNewAuthor())) {
            updatebleBook.setAuthor(bookNewInfo.getNewAuthor());
        }
        if (!Objects.isNull(bookNewInfo.getNewName())) {
            updatebleBook.setName(bookNewInfo.getNewName());
        }
        if (!Objects.isNull(bookNewInfo.getNewPublicationDate())) {
            updatebleBook.setPublicationDate(bookNewInfo.getNewPublicationDate());
        }

        bookRepository.save(updatebleBook);
    }

    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
