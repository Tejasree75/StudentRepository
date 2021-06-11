package com.example.demo.exception;

public enum ErrorCode {
    STUDENT_NOT_FOUND("S001", "Student not found"),
    NO_STUDENT_FOUND("S002", "No student found"),
    STUDENT_MATCH_NOT_FOUND("S003", "Student for this id not found");
    private String errorCode;
    private String errorMessage;

    ErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}


