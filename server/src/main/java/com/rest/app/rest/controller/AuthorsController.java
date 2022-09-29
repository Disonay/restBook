package com.rest.app.rest.controller;

import com.rest.app.rest.dto.author.AuthorDTO;
import com.rest.app.rest.dto.author.AuthorNewInfo;
import com.rest.app.rest.manager.AuthorManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorsController implements CrudlController<AuthorDTO, AuthorNewInfo>{

    private final AuthorManager authorManager;

    @Override
    public void create(AuthorDTO authorDTO) {
        authorManager.create(authorDTO);
    }

    @Override
    public AuthorDTO read(Long authorId) {
        return authorManager.read(authorId);
    }

    @Override
    public List<AuthorDTO> list() {
        return authorManager.list();
    }

    @Override
    public void update(Long authorId, AuthorNewInfo authorNewInfo) {
        authorManager.update(authorId,authorNewInfo);
    }

    @Override
    public void delete(Long authorId) {
        authorManager.delete(authorId);
    }
}
