package com.rest.app.validation.author;

import com.rest.app.exception.EntityAlreadyExistException;
import com.rest.app.repository.author.AuthorRepository;
import com.rest.app.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NewAuthorIdValidator implements Validator<Long> {
    private final AuthorRepository authorRepository;

    @Override
    public void validate(Long obj) {
        if (authorRepository.existsById(obj)) {
            throw new EntityAlreadyExistException();
        }
    }
}