package com.javaWithSpringCourse.smsBoot.repository;


import com.javaWithSpringCourse.smsBoot.entity.SubjectMark;
import com.javaWithSpringCourse.smsBoot.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sailesh on 1/12/22.
 */
public class FileSubjectMarkRepository implements  SubjectMarkRepository{

    private static final String FILE_NAME = "subjectMark.txt";
    @Override
    public List<SubjectMark> createSubjectMark(List<SubjectMark> subjectMarks) {
        StringBuilder stringBuilder = new StringBuilder();

        for(SubjectMark subjectMark : subjectMarks) {
            stringBuilder.append(subjectMark.toCsvString());
            stringBuilder.append(System.lineSeparator());
        }
        FileUtil.saveRecordsToFile(FILE_NAME, stringBuilder.toString());
        return  subjectMarks;
    }

    @Override
    public List<SubjectMark> getAllSubjectMarks(Integer studentId) {
        String records = FileUtil.getRecordByKeyAndIndex(FILE_NAME, studentId, 1);
        return toStudentMarkObject(records);
    }


    private List<SubjectMark> toStudentMarkObject(String record) {
        List<SubjectMark> studentMarks = new ArrayList<>();
        if(record != null && !record.isEmpty()){
            String[] rows = record.split("\n");
            for(String row : rows) {
                String[] fields = row.split(",");
                SubjectMark subjectMark = new SubjectMark();

                try{
                    subjectMark.setSubjectMarkID(Integer.parseInt(fields[0]));
                } catch (NumberFormatException e) {
                    //do nothing
                }
                subjectMark.setStudentId(Integer.parseInt(fields[1]));
                subjectMark.setSubjectId(Integer.parseInt(fields[2]));
                subjectMark.setMarks(Double.parseDouble(fields[3]));

                studentMarks.add(subjectMark);
            }
        }

        return studentMarks;

    }
}
