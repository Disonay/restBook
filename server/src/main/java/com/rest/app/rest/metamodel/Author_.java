package com.rest.app.rest.metamodel;

import com.rest.app.rest.entity.AuthorEntity;
import com.rest.app.rest.entity.BookEntity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(AuthorEntity.class)
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Author_ {
    public static volatile SingularAttribute<AuthorEntity, Integer> id;
    public static volatile SingularAttribute<AuthorEntity, String> surname;
    public static volatile SingularAttribute<AuthorEntity, String> name;
    public static volatile SingularAttribute<AuthorEntity, String> middleName;
    public static volatile ListAttribute<AuthorEntity, BookEntity> books;

    public static final String ID = "id";
    public static final String SURNAME = "surname";
    public static final String NAME = "name";
    public static final String MIDDLE_NAME = "middleName";
    public static final String BOOKS = "books";
}
