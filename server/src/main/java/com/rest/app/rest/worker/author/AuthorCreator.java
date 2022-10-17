package com.rest.app.rest.worker.author;

import com.rest.app.rest.dto.author.AuthorDTO;
import com.rest.app.rest.mapper.AuthorMapper;
import com.rest.app.rest.repository.author.AuthorRepository;
import com.rest.app.general.VoidWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorCreator implements VoidWorker {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private AuthorDTO authorDTO;

    public VoidWorker payload(AuthorDTO data) {
        this.authorDTO = data;

        return this;
    }

    @Override
    public void execute() {
        authorRepository.save(authorMapper.authorDtoToAuthor(authorDTO));
    }
}
