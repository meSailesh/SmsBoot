package com.javaWithSpringCourse.smsBoot.exception;

import com.javaWithSpringCourse.smsBoot.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by sailesh on 1/29/22.
 */
@ControllerAdvice
public class StudentNotFoundExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<?> handleStudentNotFoundException(StudentNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                new Date(),
                HttpStatus.BAD_REQUEST.getReasonPhrase()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
