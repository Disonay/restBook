package com.rest.app.rest.validation;

public interface Validator<T> {
    void validate(T obj);
}
