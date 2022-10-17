package com.rest.app.rest.validation.author;

import com.rest.app.rest.dto.author.AuthorDTO;
import com.rest.app.rest.exception.EntityNotFoundException;
import com.rest.app.rest.mapper.AuthorMapper;
import com.rest.app.rest.repository.author.AuthorRepository;
import com.rest.app.general.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistAuthorValidator implements Validator<AuthorDTO> {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    @Override
    public void validate(AuthorDTO obj) {
        if (!authorRepository.exists(Example.of(authorMapper.authorDtoToAuthor(obj)))) {
            throw new EntityNotFoundException();
        }
    }
}
