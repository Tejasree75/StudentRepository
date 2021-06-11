package com.example.demo.exception;

public class NoStudentFoundException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public NoStudentFoundException(ErrorCode errorCode) {

        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage();
    }
}
