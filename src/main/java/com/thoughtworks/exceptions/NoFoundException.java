package com.thoughtworks.exceptions;

public class NoFoundException extends RuntimeException{
    NoFoundException(String message){
        super(message);
    }
}
