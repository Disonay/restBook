package com.rest.app.api.scheduled;

import com.rest.app.api.parser.BookParser;
import com.rest.app.api.json.Book;
import com.rest.app.rest.worker.book.BooksCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

@RequiredArgsConstructor
@Component
public class Job {
    private final BookParser bookParser;
    private final BooksCreator booksCreator;


    @Async
    public Future<Void> run(List<Book> buffer) {
        while (!buffer.isEmpty()) {
            booksCreator.payload(bookParser.parse(buffer.get(0))).execute();
            buffer.remove(0);
            if (Thread.interrupted()) {
                return null;
            }
        }
        return null;
    }
}