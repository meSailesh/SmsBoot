package com.javaWithSpringCourse.smsBoot.model;

/**
 * Created by sailesh on 1/12/22.
 */
public enum Subject {
    ENGLISH(1, "English"),
    NEPALI(2, "Nepali"),
    SCIENCE(3, "Science"),
    MATH(4, "Math");

    //name(key, description)

    private Integer key;
    private String description;

    public Integer getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    Subject(Integer key, String description) {
        this.key = key;
        this.description = description;
    }


    public static  Subject lookupByKey(Integer key) {
        for(Subject subject : Subject.values()) {
            if(subject.getKey() == key) {
                return  subject;
            }

        }
        return null;

    }



}
