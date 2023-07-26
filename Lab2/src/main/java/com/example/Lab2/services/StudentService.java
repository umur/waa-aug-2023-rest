package com.example.Lab2.services;

import com.example.Lab2.dto.CourseDto;
import com.example.Lab2.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAll();

    StudentDto getById(int id);

    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int studentId);

    void create(StudentDto student);

    void update(StudentDto student);

    void deleteById(int id);
}
