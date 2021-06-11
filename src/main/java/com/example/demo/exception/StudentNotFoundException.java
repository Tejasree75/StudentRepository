package com.example.demo.exception;

public class StudentNotFoundException extends RuntimeException {
    private int studentId;
    private String errorCode;
    private String errorMessage;


    public int getStudentId() {

        return studentId;
    }

    public String getErrorCode() {

        return errorCode;
    }

    public String getErrorMessage() {

        return errorMessage;
    }

    public StudentNotFoundException(ErrorCode errorCode, int studentId) {
        this.studentId = studentId;
        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage();
    }
}
