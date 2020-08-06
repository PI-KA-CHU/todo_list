package com.thoughtworks.common;

import com.thoughtworks.exceptions.TodoInfoErrorException;
import com.thoughtworks.exceptions.TodoNoFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(TodoNoFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void todoNotFound(TodoNoFoundException exception) {
        log.error(exception.getMessage());
    }

    @ExceptionHandler(TodoInfoErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void todoInfoError(TodoInfoErrorException exception) {
        log.error(exception.getMessage());
    }
}
