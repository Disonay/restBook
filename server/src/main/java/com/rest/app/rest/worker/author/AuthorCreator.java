package com.rest.app.rest.worker.author;

import com.rest.app.rest.dto.author.AuthorDTO;
import com.rest.app.rest.mapper.AuthorMapper;
import com.rest.app.rest.repository.author.AuthorRepository;
import com.rest.app.general.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorCreator implements Worker {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private AuthorDTO authorDTO;

    public Worker payload(AuthorDTO data) {
        this.authorDTO = data;

        return this;
    }

    @Override
    public void execute() {
        authorRepository.save(authorMapper.authorDtoToAuthor(authorDTO));
    }
}
