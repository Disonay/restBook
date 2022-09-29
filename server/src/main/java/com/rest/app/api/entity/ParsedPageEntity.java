package com.rest.app.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PAGE")
@Getter
@Setter
public class ParsedPageEntity {
    @Id
    @SequenceGenerator(name = "page_seq", sequenceName = "PAGE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "page_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "page")
    private Long page;

    @Column(name = "parse_date")
    private Date parseDate;
}
