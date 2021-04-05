package com.example.user_project.exception;

public class LoginAlreadyExistsException extends RuntimeException {

    public LoginAlreadyExistsException(String message) {
        super(message);
    }
}
