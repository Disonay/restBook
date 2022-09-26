package com.rest.app.validation.book;

import com.rest.app.exception.EntityNotFoundException;
import com.rest.app.repository.book.BookRepository;
import com.rest.app.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistBookIdValidator implements Validator<Long> {
    private final BookRepository bookRepository;
    @Override
    public void validate(Long obj) {
        if (!bookRepository.existsById(obj)) {
            throw new EntityNotFoundException();
        }
    }
}
