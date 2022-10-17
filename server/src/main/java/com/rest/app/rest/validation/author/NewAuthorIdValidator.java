package com.rest.app.rest.validation.author;

import com.rest.app.rest.exception.EntityAlreadyExistException;
import com.rest.app.rest.repository.author.AuthorRepository;
import com.rest.app.general.Validator;
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