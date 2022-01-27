package com.javaWithSpringCourse.smsBoot.exception;

/**
 * Created by sailesh on 1/28/22.
 */
public class StudentNotFountException extends  RuntimeException{

    public StudentNotFountException(Integer id) {
        super("Couldnot find the student with id " + id);
    }
}
