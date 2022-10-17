package com.rest.app.api.worker.page;

import com.rest.app.api.entity.ParsedPageEntity;
import com.rest.app.api.repository.page.ParsedPageRepository;
import com.rest.app.general.VoidWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class PageSaver implements VoidWorker {
    private final ParsedPageRepository parsedPageRepository;
    private Long page;

    public VoidWorker payload(Long data) {
        this.page = data;

        return this;
    }

    @Override
    public void execute() {
        ParsedPageEntity parsedPageEntity = new ParsedPageEntity();
        parsedPageEntity.setParseDate(new Date());
        parsedPageEntity.setPage(page);

        parsedPageRepository.save(parsedPageEntity);
    }
}
