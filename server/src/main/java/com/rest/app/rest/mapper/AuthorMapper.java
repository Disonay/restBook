package com.rest.app.rest.mapper;

import com.rest.app.rest.dto.author.AuthorDTO;
import com.rest.app.rest.entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO authorToAuthorDto(AuthorEntity authorEntity);
    List<AuthorDTO> authorToAuthorDto(List<AuthorEntity> authorEntityList);

    @Mapping(target = "books", ignore = true)
    AuthorEntity authorDtoToAuthor(AuthorDTO authorDTO);
}
