package com.rest.app.provider;

import com.rest.app.dto.author.AuthorDTO;
import com.rest.app.entity.AuthorEntity;
import com.rest.app.mapper.AuthorMapper;
import com.rest.app.repository.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorProvider implements Provider<AuthorDTO>{

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorDTO getEntityById(Long authorId) {
        Optional<AuthorEntity> optionalAuthor = authorRepository.findById(authorId);

        return AuthorMapper.INSTANCE.authorToAuthorDto(optionalAuthor.get());
    }

    @Override
    public List<AuthorDTO> getAllEntities() {
        return authorMapper.authorToAuthorDto(authorRepository.findAll());
    }
}
