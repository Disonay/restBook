package com.rest.app.rest.metamodel;

import com.rest.app.rest.deleted.Deleted;
import com.rest.app.rest.entity.AuthorEntity;
import com.rest.app.rest.entity.BookEntity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(BookEntity.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Book_ {
    public static volatile SingularAttribute<BookEntity, Long> id;
    public static volatile SingularAttribute<BookEntity, AuthorEntity> author;
    public static volatile SingularAttribute<BookEntity, String> title;
    public static volatile SingularAttribute<BookEntity, Date> publicationDate;
    public static volatile SingularAttribute<BookEntity, Deleted> deleted;

    public static final String ID = "id";
    public static final String AUTHOR = "author";
    public static final String TITLE = "title";
    public static final String PUBLICATION_DATE = "publicationDate";
    public static final String DELETED = "deleted";
}
