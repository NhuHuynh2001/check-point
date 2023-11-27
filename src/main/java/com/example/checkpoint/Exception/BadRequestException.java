package com.example.checkpoint.Exception;

import lombok.Getter;

@Getter
public enum BadRequestException  {
    UNKNOWN(0 ,"Unknown"),
    SCORE_NOT_FOUND(100, "score not found"),
    INVALID_POINT(101, "Invalid point"),
    NO_STATUS_IN_VALID(103,"No status in valid"),
    NO_VALUE(104, "No value"),
    NO_VALUE_TO_SORT(105,"No value  to sort")
    ;

    private int errorCode;
    private String message;

    BadRequestException(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }



}
