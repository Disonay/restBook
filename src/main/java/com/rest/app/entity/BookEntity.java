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
@Setter
@Getter
public class BookEntity {
    @Id
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="author", nullable = false, length = 50)
    private String author;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="publication_date", nullable = false)
    private Date publicationDate;
}
