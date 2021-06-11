package com.example.demo.exception;

public class StudentMatchNotFoundException extends RuntimeException {
    private int studentId;
    private String studentName;
    private String errorCode;
    private String errorMessage;

    public int getStudentId() {

        return studentId;
    }

    public String getStudentName() {

        return studentName;
    }

    public String getErrorCode() {

        return errorCode;
    }

    public String getErrorMessage() {

        return errorMessage;
    }

    public StudentMatchNotFoundException(ErrorCode errorCode, int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage();
    }
}
