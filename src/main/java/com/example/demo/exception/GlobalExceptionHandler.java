package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleStudentNotFound(StudentNotFoundException e, WebRequest request) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put("code", e.getErrorCode());
        values.put("message", e.getErrorMessage());
        values.put("studid", e.getStudentId());
        return new ResponseEntity<Object>(values, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoStudentFoundException.class)
    public ResponseEntity<Object> handleNoStudentFound(NoStudentFoundException e, WebRequest request) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put("code", e.getErrorCode());
        values.put("message", e.getErrorMessage());
        return new ResponseEntity<Object>(values, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentMatchNotFoundException.class)
    public ResponseEntity<Object> handleStudentMatchNotFound(StudentMatchNotFoundException e, WebRequest request) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put("code", e.getErrorCode());
        values.put("message", e.getErrorMessage());
        values.put("studid", e.getStudentId());
        values.put("studname", e.getStudentName());
        return new ResponseEntity<Object>(values, HttpStatus.NOT_FOUND);
    }


}
