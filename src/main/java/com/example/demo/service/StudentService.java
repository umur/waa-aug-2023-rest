package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void save(StudentDto student);

    List<StudentDto> getAll();

    StudentDto getById(int id);

    void update(StudentDto studentDto, int id);

    void delete(int id);

    List<StudentDto> getByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int id);
}
