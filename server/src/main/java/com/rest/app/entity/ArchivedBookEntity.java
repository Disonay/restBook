package com.rest.app.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOK_ARCHIVE", indexes = @Index(name = "book_archive_title_i", columnList = "title"))
@Validated
@Setter
@Getter
public class ArchivedBookEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publication_date", nullable = false)
    private Date publicationDate;
}

