package com.rest.app.repository;

import com.rest.app.entity.AuthorEntity;
import org.mapstruct.Named;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Named("Repository")
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>  {
}
