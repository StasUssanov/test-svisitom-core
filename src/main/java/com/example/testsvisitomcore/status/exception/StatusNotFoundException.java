package com.example.testsvisitomcore.status.exception;

public class StatusNotFoundException extends Exception {
    public StatusNotFoundException() {
        super(ExceptionMessages.STATUS_NOT_FOUND.name());
    }

    public StatusNotFoundException(String message) {
        super(message);
    }
}
