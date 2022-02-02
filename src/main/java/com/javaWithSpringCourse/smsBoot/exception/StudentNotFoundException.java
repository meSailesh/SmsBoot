package com.javaWithSpringCourse.smsBoot.exception;

/**
 * Created by sailesh on 1/29/22.
 */
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Integer studentId) {
        super("Couldn't find any student with id " + studentId + " in our record. Try again");
    }
}
