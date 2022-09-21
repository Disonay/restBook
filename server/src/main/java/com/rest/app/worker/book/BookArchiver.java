package com.rest.app.worker.book;

import com.rest.app.entity.BookEntity;
import com.rest.app.mapper.BookMapper;
import com.rest.app.repository.ArchivedBookRepository;
import com.rest.app.repository.BookRepository;
import com.rest.app.worker.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookArchiver implements Worker {

    private final BookRepository bookRepository;
    private final ArchivedBookRepository archivedBookRepository;
    private final BookMapper bookMapper;
    private Long id;

    public Worker payload(Long data) {
        this.id = data;

        return this;
    }

    @Override
    public void execute() {
        BookEntity archivedBook = bookRepository.findById(id).get();
        archivedBookRepository.save(bookMapper.bookToArchive(archivedBook));
    }
}
