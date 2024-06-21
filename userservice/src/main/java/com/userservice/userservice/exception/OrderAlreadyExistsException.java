package com.userservice.userservice.exception;

public class OrderAlreadyExistsException  extends Exception{
    public OrderAlreadyExistsException(String message) {
        super(message);
    }
}
