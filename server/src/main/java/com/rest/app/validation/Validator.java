package com.rest.app.validation;

public interface Validator<T> {
    void validate(T obj);
}
