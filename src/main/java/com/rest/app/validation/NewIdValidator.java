package com.rest.app.validation;

import com.rest.app.exception.BookAlreadyExistException;
import com.rest.app.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NewIdValidator implements Validator<Long>{
    private final BookRepository bookRepository;

    @Override
    public void validate(Long obj) {
        if (bookRepository.existsById(obj)) {
            throw new BookAlreadyExistException();
        }
    }
}