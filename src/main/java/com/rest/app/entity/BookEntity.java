package com.rest.app.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "BOOK")
@Validated
public class BookEntity {
    @Id
    @Column(name="id", nullable = false)
    @Setter
    @Getter
    private Long id;

    @Column(name="author", nullable = false, length = 50)
    @Setter
    @Getter
    private String author;

    @Column(name="name", nullable = false)
    @Setter
    @Getter
    private String name;

    @Column(name="publication_date", nullable = false)
    @Setter
    @Getter
    private Date publicationDate;
}
