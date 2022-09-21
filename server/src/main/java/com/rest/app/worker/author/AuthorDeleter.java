package com.rest.app.worker.author;

import com.rest.app.repository.AuthorRepository;
import com.rest.app.worker.Worker;
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
