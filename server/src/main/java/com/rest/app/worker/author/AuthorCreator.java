package com.rest.app.worker.author;

import com.rest.app.dto.author.AuthorDTO;
import com.rest.app.mapper.AuthorMapper;
import com.rest.app.repository.AuthorRepository;
import com.rest.app.worker.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorCreator implements Worker<AuthorDTO> {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private AuthorDTO authorDTO;

    public AuthorCreator payload(AuthorDTO data) {
        this.authorDTO = data;

        return this;
    }

    @Override
    public void execute() {
        authorRepository.save(authorMapper.authorDtoToAuthor(authorDTO));
    }
}
