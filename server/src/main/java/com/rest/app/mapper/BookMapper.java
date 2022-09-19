package com.rest.app.mapper;

import com.rest.app.dto.book.BookDTO;
import com.rest.app.entity.AuthorEntity;
import com.rest.app.entity.BookEntity;
import com.rest.app.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class BookMapper {

    @Setter
    @Autowired
    protected AuthorRepository authorRepository;

    @Mapping(source = "author.id", target = "authorId")
    public abstract BookDTO bookToBookDto(BookEntity bookEntity);

    public abstract List<BookDTO> bookToBookDto(List<BookEntity> bookEntityList);

    @Mapping(target = "author", source = "authorId", qualifiedByName = "IdToAuthor")
    public abstract BookEntity bookDtoToBook(BookDTO bookDTO);

    @Named("IdToAuthor")
    AuthorEntity idToAuthor(Long authorId) {
        return authorRepository.findById(authorId).get();
    }


}
