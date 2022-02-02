package com.javaWithSpringCourse.smsBoot.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by sailesh on 1/29/22.
 */
public class ErrorResponse {
    private Integer code;
    private String error;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timeStamp;

    public ErrorResponse(Integer code, String message, Date timeStamp, String error) {
        this.code = code;
        this.message = message;
        this.timeStamp = timeStamp;
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
