package com.rest.app.rest.manager;

import com.rest.app.rest.dto.author.AuthorDTO;
import com.rest.app.rest.dto.author.AuthorNewInfo;
import com.rest.app.rest.provider.AuthorProvider;
import com.rest.app.rest.validation.author.ExistAuthorIdValidator;
import com.rest.app.rest.worker.author.AuthorCreator;
import com.rest.app.rest.worker.author.AuthorDeleter;
import com.rest.app.rest.worker.author.AuthorUpdater;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorManager implements Manager<AuthorDTO, AuthorNewInfo>{
    private final AuthorCreator creator;
    private final AuthorDeleter deleter;
    private final AuthorUpdater updater;
    private final AuthorProvider provider;
    private final ExistAuthorIdValidator existIdValidator;

    @Override
    public void create(AuthorDTO authorDTO) {
        creator.payload(authorDTO).execute();
    }

    @Override
    public AuthorDTO read(Long authorId) {
        existIdValidator.validate(authorId);

        return provider.getEntityById(authorId);
    }

    @Override
    public List<AuthorDTO> list() {
        return provider.getAllEntities();
    }

    @Override
    public void update(Long authorId, AuthorNewInfo authorNewInfo) {
        existIdValidator.validate(authorId);
        updater.payload(authorId, authorNewInfo).execute();
    }

    @Override
    public void delete(Long authorId) {
        existIdValidator.validate(authorId);
        deleter.payload(authorId).execute();
    }
}
