package com.javaWithSpringCourse.smsBoot.exception;

/**
 * Created by sailesh on 2/2/22.
 */
public class InvalidFileFormatException extends RuntimeException{

    public InvalidFileFormatException() {
        super("error parsing file. please try again!");
    }
}
