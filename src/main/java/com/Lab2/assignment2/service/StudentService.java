package com.Lab2.assignment2.service;

import com.Lab2.assignment2.dto.StudentDto;
import com.Lab2.assignment2.entity.Course;
import com.Lab2.assignment2.entity.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);

    void delete(int studentId);

    void update(Student student, int studentId);

    List<Student> getAll();

    Student getById(int studentId);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);


}
