package com.example.checkpoint.Exception;

import lombok.Getter;

@Getter
public enum InternalServerException {
    UNKNOWN(0, "UNKNOWN"),
    INTERNAL_SERVER_ERROR(100, "INTERNAL ERROR");

    private int errorCode;
    private String message;

    InternalServerException(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
