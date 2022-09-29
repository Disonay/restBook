package com.rest.app.api.provider;

import com.rest.app.api.entity.ParsedPageEntity;
import com.rest.app.api.repository.page.ParsedPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PageProvider {
    private final ParsedPageRepository parsedPageRepository;

    public Long getLastPage() {
        Optional<ParsedPageEntity> page = parsedPageRepository.findTopByOrderByIdDesc();

        if (page.isPresent()) {
            return page.get().getPage();
        }

        return -1L;
    }
}
