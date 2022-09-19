package com.rest.app.mapper;

import com.rest.app.dto.author.AuthorDTO;
import com.rest.app.entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO authorToAuthorDto(AuthorEntity authorEntity);
    List<AuthorDTO> authorToAuthorDto(List<AuthorEntity> authorEntityList);

    AuthorEntity authorDtoToAuthor(AuthorDTO authorDTO);
}
