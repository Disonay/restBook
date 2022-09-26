package com.rest.app.worker.author;

import com.rest.app.dto.author.AuthorNewInfo;
import com.rest.app.entity.AuthorEntity;
import com.rest.app.repository.author.AuthorRepository;
import com.rest.app.worker.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorUpdater implements Worker{
    private final AuthorRepository authorRepository;
    private Long authorId;
    private AuthorNewInfo authorNewInfo;


    public Worker payload(Long authorId, AuthorNewInfo data) {
        this.authorId = authorId;
        this.authorNewInfo = data;

        return this;
    }

    @Override
    public void execute() {
        Optional<AuthorEntity> optionalAuthor = authorRepository.findById(authorId);
        AuthorEntity updatebleAuthor = optionalAuthor.get();

        if (!Objects.isNull(authorNewInfo.getSurname())) {
            updatebleAuthor.setSurname(authorNewInfo.getSurname());
        }
        if (!Objects.isNull(authorNewInfo.getName())) {
            updatebleAuthor.setName(authorNewInfo.getName());
        }
        if (!Objects.isNull(authorNewInfo.getMiddleName())) {
            updatebleAuthor.setMiddleName(authorNewInfo.getMiddleName());
        }

        authorRepository.save(updatebleAuthor);
    }
}
