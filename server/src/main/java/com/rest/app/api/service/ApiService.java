package com.rest.app.api.service;

import com.rest.app.api.json.Results;
import com.rest.app.api.provider.PageProvider;
import com.rest.app.api.worker.page.PageSaver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ApiService {
    private final RestTemplateBuilder restTemplateBuilder;
    private final PageProvider provider;
    private final PageSaver pageSaver;

    @Value("${api.url}")
    private String url;

    public Results getBooks() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<Results> responseEntity = restTemplate.getForEntity(
                url + (provider.getLastPage() + 1), Results.class
        );
        pageSaver.payload(provider.getLastPage() + 1).execute();

        return responseEntity.getBody();
    }
}
