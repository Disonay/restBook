package com.rest.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
@Getter
@Setter
public class AuthorEntity {
    @Id
    @SequenceGenerator(name = "author_seq", sequenceName = "AUTHOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    @Column(name="id")
    private Long id;

    @Column(name="surname", nullable = false, length = 50)
    private String surname;

    @Column(name="name", nullable = false, length = 50)
    private String name;

    @Column(name="middle_name", nullable = false, length = 50)
    private String middleName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<BookEntity> books;

}
