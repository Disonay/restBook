package com.rest.app.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOK")
@Validated
@Setter
@Getter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="author", nullable = false, length = 50)
    private String author;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="publication_date", nullable = false)
    private Date publicationDate;
}
