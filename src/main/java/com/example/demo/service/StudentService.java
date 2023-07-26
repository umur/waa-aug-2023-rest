package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student getStudentById(int id);

    List<Student> getStudents();

    void deleteStudentById(int id);

    Student updateStudent(int id, Student student);

    List<Student> getStudentsByMajor(String major);

    List<String> getCourseByStudentId(int studentId);
}

