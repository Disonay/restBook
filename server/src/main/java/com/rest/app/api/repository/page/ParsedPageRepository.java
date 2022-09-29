package com.rest.app.api.repository.page;

import com.rest.app.api.entity.ParsedPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParsedPageRepository extends JpaRepository<ParsedPageEntity, Long> {
    Optional<ParsedPageEntity> findTopByOrderByIdDesc();
}
