package com.rest.app.worker;

public interface Worker<T> {
    Worker<T> payload(T data);
    void execute();
}
