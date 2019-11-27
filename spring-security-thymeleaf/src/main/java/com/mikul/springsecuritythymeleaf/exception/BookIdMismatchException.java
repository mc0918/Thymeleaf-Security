package com.mikul.springsecuritythymeleaf.exception;

public class BookIdMismatchException extends RuntimeException {
    public BookIdMismatchException(String message) {
        super(message);
    }
}
