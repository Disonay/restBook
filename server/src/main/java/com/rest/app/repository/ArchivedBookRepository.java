package com.rest.app.repository;

import com.rest.app.entity.ArchivedBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchivedBookRepository extends JpaRepository<ArchivedBookEntity, Long> {
}
