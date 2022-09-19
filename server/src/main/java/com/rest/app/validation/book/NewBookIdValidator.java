package com.rest.app.validation.book;

import com.rest.app.exception.EntityAlreadyExistException;
import com.rest.app.repository.BookRepository;
import com.rest.app.validation.Validator;
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