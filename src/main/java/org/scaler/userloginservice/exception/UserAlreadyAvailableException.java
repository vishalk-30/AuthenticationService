package org.scaler.userloginservice.exception;

public class UserAlreadyAvailableException extends RuntimeException {
    public UserAlreadyAvailableException(String message) {
        super(message);
    }
}
