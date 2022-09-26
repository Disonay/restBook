package com.rest.app.repository;

import com.rest.app.entity.AuthorEntity;
import com.rest.app.entity.BookEntity;
import com.rest.app.metamodel.Author_;
import com.rest.app.metamodel.Book_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements CustomBookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<BookEntity> findBooksByAuthorNameAndTitle(String title, String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BookEntity> criteria = cb.createQuery(BookEntity.class);
        Root<BookEntity> root = criteria.from(BookEntity.class);
        Join<BookEntity, AuthorEntity> author = root.join(Book_.AUTHOR);


        Predicate filterTitle = cb.equal(root.get(Book_.TITLE), title);
        Predicate filterAuthorName = cb.equal(author.get(Author_.NAME), name);
        Predicate finalPredicate = cb.and(filterTitle, filterAuthorName);

        criteria.where(finalPredicate);

        return em.createQuery(criteria).getResultList();

    }

    @Override
    public List<BookEntity> findBooksByOneInput(String search) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BookEntity> criteria = cb.createQuery(BookEntity.class);
        Root<BookEntity> root = criteria.from(BookEntity.class);
        Join<BookEntity, AuthorEntity> author = root.join(Book_.AUTHOR);

        String[] tokens = search.split(" ");
        List<Predicate> bookPredicates = new ArrayList<>();
        List<Predicate> authorPredicates = new ArrayList<>();
        for (String token: tokens) {
            bookPredicates.add(cb.like(cb.lower(root.get(Book_.TITLE)), "%"+token.toLowerCase()+"%"));
            authorPredicates.add(cb.like(cb.lower(author.get(Author_.NAME)), "%"+token.toLowerCase()+"%"));
        }


        Predicate bookPredicate = cb.or(bookPredicates.toArray(new Predicate[0]));
        Predicate authorPredicate = cb.or(authorPredicates.toArray(new Predicate[0]));
        Predicate finalPredicate = cb.and(bookPredicate, authorPredicate);
        criteria.where(finalPredicate);

        return em.createQuery(criteria).getResultList();
    }
}
