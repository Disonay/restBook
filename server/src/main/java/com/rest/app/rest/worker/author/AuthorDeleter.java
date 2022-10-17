package com.rest.app.rest.worker.author;

import com.rest.app.rest.repository.author.AuthorRepository;
import com.rest.app.general.VoidWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorDeleter implements VoidWorker {
    private final AuthorRepository authorRepository;
    private Long id;

    public VoidWorker payload(Long data) {
        this.id = data;

        return this;
    }

    @Override
    public void execute() {
        authorRepository.deleteById(id);
    }
}
