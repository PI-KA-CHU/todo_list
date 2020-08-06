package com.thoughtworks.exceptions;

import com.thoughtworks.enums.TodoEnums;

public class TodoNoFoundException extends BaseException{
    public TodoNoFoundException(TodoEnums enumMess) {
        super(enumMess);
    }
}
