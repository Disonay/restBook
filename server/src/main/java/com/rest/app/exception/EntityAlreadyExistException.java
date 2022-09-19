package com.rest.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EntityAlreadyExistException extends RuntimeException {
    public EntityAlreadyExistException() {
        super();
    }
}
