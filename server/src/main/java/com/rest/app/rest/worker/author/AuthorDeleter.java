package com.rest.app.rest.worker.author;

import com.rest.app.rest.repository.author.AuthorRepository;
import com.rest.app.general.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorDeleter implements Worker {
    private final AuthorRepository authorRepository;
    private Long id;

    public Worker payload(Long data) {
        this.id = data;

        return this;
    }

    @Override
    public void execute() {
        authorRepository.deleteById(id);
    }
}
