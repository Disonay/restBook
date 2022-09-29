package com.rest.app.api.parser;

import com.rest.app.rest.dto.book.BookDTO;
import com.rest.app.api.json.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookParser implements Parser<Book, List<BookDTO>>{
    private final AuthorParser authorParser;

    @Override
    public List<BookDTO> parse(Book data) {
        List<BookDTO> booksDTO = new ArrayList<>();
        for (String author: data.getAuthors()) {
            BookDTO bookDTO = new BookDTO();

            bookDTO.setTitle(data.getTitle());
            bookDTO.setAuthor(authorParser.parse(author));
            bookDTO.setPublicationDate(data.getPublicationDate());

            booksDTO.add(bookDTO);
        }

        return booksDTO;
    }
}
