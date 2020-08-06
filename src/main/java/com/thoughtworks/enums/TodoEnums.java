package com.thoughtworks.enums;

public enum TodoEnums {

    TODO_NO_FOUND_ERROR("id error,please input current id"),
    TODO_INFO_ERROE("please input correct todo info");

    private String message;

    TodoEnums(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
