package com.rest.app.rest.repository.book;

import com.rest.app.rest.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>, CustomBookRepository {
    @Modifying
    @Transactional
    @Query("UPDATE BookEntity bookEntity SET bookEntity.deleted = 'Y' WHERE bookEntity.id = ?1")
    void softDeleteById(Long bookId);

    @Query("SELECT book FROM BookEntity book WHERE book.deleted = 'N' ")
    List<BookEntity> findAllByDeletedIsFalse();
}
