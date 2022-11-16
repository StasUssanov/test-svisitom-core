package com.example.testsvisitomcore.status.exception;

public class StatusSerialNumberBusyException extends Exception {
    public StatusSerialNumberBusyException() {
        super(ExceptionMessages.STATUS_SERIAL_NUMBER_BUSY.name());
    }

    public StatusSerialNumberBusyException(String message) {
        super(message);
    }
}
