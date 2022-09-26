package com.rest.app.validation.author;

import com.rest.app.exception.EntityNotFoundException;
import com.rest.app.repository.author.AuthorRepository;
import com.rest.app.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistAuthorIdValidator implements Validator<Long> {
    private final AuthorRepository authorRepository;
    @Override
    public void validate(Long obj) {
        if (!authorRepository.existsById(obj)) {
            throw new EntityNotFoundException();
        }
    }
}
