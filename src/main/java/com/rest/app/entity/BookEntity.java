package com.rest.app.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "books", schema = "public")
@Data
public class BookEntity {
    @Id
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="author", nullable = false)
    private String author;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="date", nullable = false)
    private Date date;
}
