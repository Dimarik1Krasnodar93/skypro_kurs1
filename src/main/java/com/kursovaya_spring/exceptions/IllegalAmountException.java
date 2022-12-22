package com.kursovaya_spring.exceptions;

public class IllegalAmountException extends RuntimeException {
    public IllegalAmountException(String name) {
        super(name);
    }
}
