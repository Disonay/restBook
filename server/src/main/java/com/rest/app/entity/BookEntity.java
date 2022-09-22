package com.rest.app.entity;

import com.rest.app.deleted.Deleted;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOK", indexes = {
        @Index(name = "book_title_i", columnList = "title"),
        @Index(name = "book_del_i", columnList = "deleted")
})
@Validated
@Setter
@Getter
public class BookEntity {
    @Id
    @SequenceGenerator(name = "book_seq", sequenceName = "BOOK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private AuthorEntity author;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publication_date", nullable = false)
    private Date publicationDate;

    @Column(name = "deleted", columnDefinition = "varchar(1) default 'N'")
    @Enumerated(EnumType.STRING)
    private Deleted deleted = Deleted.N;

}
