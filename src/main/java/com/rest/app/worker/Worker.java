package com.rest.app.worker;

import com.rest.app.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Worker<T> {
    protected final BookRepository bookRepository;
    protected T data;

    public abstract Worker<T> payload(T data);
    public abstract void execute();
}
