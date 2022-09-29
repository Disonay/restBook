package com.rest.app.api.parser;

import com.rest.app.rest.dto.author.AuthorDTO;
import com.rest.app.rest.entity.AuthorEntity;
import com.rest.app.rest.mapper.AuthorMapper;
import com.rest.app.rest.repository.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorParser implements Parser<String, AuthorDTO>{

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorDTO parse(String data) {
        String[] authorTokens = data.split(" ");

        AuthorDTO authorDTO = new AuthorDTO();

        if (authorTokens.length == 2) {
            authorDTO.setName(authorTokens[0]);
            authorDTO.setSurname(authorTokens[1]);
        }
        else if (authorTokens.length == 3) {
            authorDTO.setName(authorTokens[0]);
            authorDTO.setSurname(authorTokens[1]);
            authorDTO.setMiddleName(authorTokens[2]);
        }
        else if (authorTokens.length > 3) {
            int length = authorTokens.length;
            authorDTO.setName(authorTokens[length - 2]);
            authorDTO.setSurname(authorTokens[length - 1]);
        }

        Optional<AuthorEntity> optionalAuthor = authorRepository.findOne(
                Example.of(authorMapper.authorDtoToAuthor(authorDTO))
        );

        if (optionalAuthor.isPresent()) {
            authorDTO = authorMapper.authorToAuthorDto(optionalAuthor.get());
        }
        else {
            authorDTO.setId(authorRepository.save(authorMapper.authorDtoToAuthor(authorDTO)).getId());
        }

        return authorDTO;
    }
}
