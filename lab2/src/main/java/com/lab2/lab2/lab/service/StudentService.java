package com.lab2.lab2.lab.service;

import com.lab2.lab2.lab.entity.Course;
import com.lab2.lab2.lab.entity.Student;

import java.util.List;

public interface StudentService {

    void save(Student s);
    Student getById(int id);
    List<Student> getAll();
    void update(int id,Student student);
    void delete(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);

}
