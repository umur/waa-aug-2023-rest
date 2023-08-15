package com.example.assignment2.service;

import com.example.assignment2.dto.CourseDto;
import com.example.assignment2.dto.StudentDto;
import com.example.assignment2.entity.Course;

import java.util.List;


public interface StudentService {
    void save(StudentDto student);

    List<StudentDto> getAll();

    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int studentId);

    void remove(int studentId);

    void update(StudentDto student, int studentId);
}
