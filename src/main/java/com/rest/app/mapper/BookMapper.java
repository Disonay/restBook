package com.rest.app.mapper;

import com.rest.app.dto.BookDTO;
import com.rest.app.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDto(BookEntity bookEntity);
    List<BookDTO> bookToBookDto(List<BookEntity> bookEntityList);

    BookEntity bookDtoToBook(BookDTO bookDTO);

}
