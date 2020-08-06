package com.thoughtworks.exceptions;

import com.thoughtworks.enums.TodoEnums;

public class TodoInfoErrorException extends BaseException{
    public TodoInfoErrorException(TodoEnums enumMess) {
        super(enumMess);
    }
}
