package com.rest.app.repository;

import com.rest.app.entity.BookEntity;

import java.util.List;

public interface CustomBookRepository {
    List<BookEntity> findBooksByAuthorNameAndTitle(String title, String name);

    List<BookEntity> findBooksByOneInput(String search);
}
