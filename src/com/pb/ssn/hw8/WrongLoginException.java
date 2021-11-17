package com.pb.ssn.hw8;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Введенный логин не соответствует требованиям");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
