package com.rest.app.mapper;

import com.rest.app.dto.BookDTO;
import com.rest.app.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDto(BookEntity bookEntity);
    BookEntity bookDtoToBook(BookDTO bookDTO);
}
