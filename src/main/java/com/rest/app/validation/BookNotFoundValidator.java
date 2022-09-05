package com.rest.app.validation;

import com.rest.app.entity.BookEntity;
import com.rest.app.exception.BookNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookNotFoundValidator implements Validator<Optional<BookEntity>>{
    @Override
    public void validate(Optional<BookEntity> obj) {
        if (!obj.isPresent()) {
            throw new BookNotFoundException();
        }
    }
}
