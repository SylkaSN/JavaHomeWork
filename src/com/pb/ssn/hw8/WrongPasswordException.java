package com.pb.ssn.hw8;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Введенный пароль не соответствует требованиям");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
