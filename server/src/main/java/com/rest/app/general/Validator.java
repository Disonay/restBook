package com.rest.app.general;

public interface Validator<T> {
    void validate(T obj);
}
