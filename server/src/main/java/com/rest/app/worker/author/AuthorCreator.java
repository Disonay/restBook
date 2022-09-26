package com.rest.app.worker.author;

import com.rest.app.dto.author.AuthorDTO;
import com.rest.app.mapper.AuthorMapper;
import com.rest.app.repository.author.AuthorRepository;
import com.rest.app.worker.Worker;
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
