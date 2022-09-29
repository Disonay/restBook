package com.rest.app.api.scheduled;

import com.rest.app.api.service.ApiService;
import com.rest.app.api.json.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RequiredArgsConstructor
@Component
public class ScheduledApiDataSaver {
    private final ApiService apiService;
    private final List<Book> buffer;
    private final Job job;

    @Value("${timeout}")
    private int timeout;

    @Scheduled(fixedDelay = 60*60*1000, initialDelay = 0)
    public void timeoutScheduledSave() {
        buffer.addAll(apiService.getBooks().getResults());

        Future<Void> result = job.run(buffer);
        try {
            result.get(timeout, TimeUnit.MILLISECONDS);
        }
        catch (TimeoutException | InterruptedException | ExecutionException e) {
            result.cancel(true);
            System.out.println("Timeout");
        }
    }

}
