package com.rest.app.mapper;

import com.rest.app.dto.book.BookDTO;
import com.rest.app.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO bookToBookDto(BookEntity bookEntity);
    List<BookDTO> bookToBookDto(List<BookEntity> bookEntityList);
    BookEntity bookDtoToBook(BookDTO bookDTO);

}
