package com.rest.app.validation;

import com.rest.app.exception.BookNotFoundException;
import com.rest.app.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistIdValidator implements Validator<Long>{
    private final BookRepository bookRepository;
    @Override
    public void validate(Long obj) {
        if (!bookRepository.existsById(obj)) {
            throw new BookNotFoundException();
        }
    }
}
