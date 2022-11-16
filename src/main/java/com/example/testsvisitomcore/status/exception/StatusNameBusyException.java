package com.example.testsvisitomcore.status.exception;

public class StatusNameBusyException extends Exception {
    public StatusNameBusyException() {
        super(ExceptionMessages.STATUS_NAME_BUSY.name());
    }

    public StatusNameBusyException(String message) {
        super(message);
    }
}
