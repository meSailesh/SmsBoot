package com.javaWithSpringCourse.smsBoot.repository;


import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.utils.FileUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sailesh on 1/6/22.
 */
@Repository
@Primary
public class StudentRepositoryImpl implements StudentRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        entityManager.persist(student);
        return  student;

    }

    @Override
    @Transactional
    public Student findStudent(Integer studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> findStudent(String studentName) {
        return entityManager.createQuery(
                "select student from student as student where student.name = ?1")
                .setParameter(1, studentName)
                .getResultList();

    }

    @Override
    public List<Student> findAllStudent() {
        return  entityManager.createQuery("Select student from Student student", Student.class).getResultList();
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
         return entityManager.merge(student);

    }

    @Override
    @Transactional
    public Student deleteRecord(Student student) {
        entityManager.remove(student);
        return student;
    }
}
