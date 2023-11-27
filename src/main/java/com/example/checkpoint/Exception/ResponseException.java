package com.example.checkpoint.Exception;

import lombok.Data;

@Data
public class ResponseException extends Exception {

    private String message;
    private int errorCode;


    public ResponseException(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }


}
