package com.quark.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericException extends RuntimeException {

    private final ErrorCode errorCode;

    public GenericException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public GenericException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }


}



