package com.javaWithSpringCourse.smsBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sailesh on 1/28/22.
 */
@ControllerAdvice
public class StudentNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(StudentNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(StudentNotFountException ex) {
    return ex.getMessage();
    }
}
