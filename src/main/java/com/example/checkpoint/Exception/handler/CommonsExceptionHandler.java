package com.example.checkpoint.Exception.handler;



import com.example.checkpoint.Exception.InternalServerException;
import com.example.checkpoint.Exception.ResponseException;
import com.example.checkpoint.Model.Response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonsExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Response> handle(Exception e) {
        if (e instanceof ResponseException) {
            ResponseException exception = (ResponseException) e;
            return ResponseEntity.ok(new Response(exception.getErrorCode(), exception.getMessage()));
        } else {
            return ResponseEntity.ok(new Response(InternalServerException.INTERNAL_SERVER_ERROR.getErrorCode(), InternalServerException.INTERNAL_SERVER_ERROR.getMessage()));
        }
    }
}
