package com.thoughtworks.exceptions;

import com.thoughtworks.enums.TodoEnums;

public class BaseException extends RuntimeException{
    private String message;

    public BaseException(TodoEnums enumMess) {
        this.message = enumMess.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
