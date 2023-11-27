package com.example.checkpoint.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private final String serverDateTime = LocalDateTime.now().toString();
    private int status;
    private boolean successful;
    private String exception;
    private String message;
    private int errorCode;
    private T data;


    public Response(T data) {
        this.data = data;
        this.status = HttpStatus.OK.value();
        this.exception = "Successful";
        this.successful = Boolean.TRUE;
    }

//    public Response(BadRequestException badRequestException) {
//        this.message = badRequestException.getMessage();
//        this.errorCode = badRequestException.getErrorCode();
//        this.exception = "Error";
//        this.status = HttpStatus.BAD_REQUEST.value();
//    }



    public Response(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST.value();
        this.exception = "Error";
        this.successful = Boolean.FALSE;
    }
}
