package com.rest.app.rest.validation.book;

import com.rest.app.rest.exception.EntityAlreadyExistException;
import com.rest.app.rest.repository.book.BookRepository;
import com.rest.app.rest.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NewBookIdValidator implements Validator<Long> {
    private final BookRepository bookRepository;

    @Override
    public void validate(Long obj) {
        if (bookRepository.existsById(obj)) {
            throw new EntityAlreadyExistException();
        }
    }
}