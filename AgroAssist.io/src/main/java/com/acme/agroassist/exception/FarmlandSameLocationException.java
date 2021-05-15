package com.acme.agroassist.exception;

public class FarmlandSameLocationException extends RuntimeException{

    public FarmlandSameLocationException() {
        super("Cannot exist two farmers with same location");
    }

    public FarmlandSameLocationException(String message) {
        super(message);
    }

    public FarmlandSameLocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
