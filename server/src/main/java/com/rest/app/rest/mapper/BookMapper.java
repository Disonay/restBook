package com.rest.app.rest.mapper;

import com.rest.app.rest.dto.book.BookDTO;
import com.rest.app.rest.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses=AuthorMapper.class)
public interface BookMapper {
    BookDTO bookToBookDto(BookEntity bookEntity);
    List<BookDTO> bookToBookDto(List<BookEntity> bookEntityList);

    @Mapping(target = "deleted", ignore = true)
    BookEntity bookDtoToBook(BookDTO bookDTO);

    List<BookEntity> bookDtoToBook(List<BookDTO> bookDTOS);

}
