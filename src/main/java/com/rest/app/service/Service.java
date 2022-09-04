package com.rest.app.service;

import com.rest.app.dto.BookDTO;
import com.rest.app.dto.UpdatedBookDTO;
import com.rest.app.entity.BookEntity;
import com.rest.app.exception.BookAlreadyExistException;
import com.rest.app.exception.BookNotFoundException;
import com.rest.app.mapper.BookMapper;
import com.rest.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    BookRepository bookRepository;

    public Service(@Autowired BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

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
        return bookRepository.findBookEntitiesByAuthor(author).stream()
                .map(BookMapper.INSTANCE::bookToBookDto)
                .collect(Collectors.toList());
    }

    public void update(UpdatedBookDTO updatedBookDTO) {
        Optional<BookEntity> optionalBook = bookRepository.findById(updatedBookDTO.getId());

        if (!optionalBook.isPresent()) {
            throw new BookNotFoundException();
        }

        BookEntity updatebleBook = optionalBook.get();

        if (!Objects.isNull(updatedBookDTO.getNewAuthor())) {
            updatebleBook.setAuthor(updatedBookDTO.getNewAuthor());
        }
        if (!Objects.isNull(updatedBookDTO.getNewName())) {
            updatebleBook.setName(updatedBookDTO.getNewName());
        }
        if (!Objects.isNull(updatedBookDTO.getNewPublicationDate())) {
            updatebleBook.setPublicationDate(updatedBookDTO.getNewPublicationDate());
        }

        bookRepository.save(updatebleBook);
    }

    public void clear() {
        bookRepository.deleteAll();
    }
}
