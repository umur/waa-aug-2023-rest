package com.example.demo.service;

import com.example.demo.dto.StudentCourseDto;
import com.example.demo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {
    void save(StudentDto student);

    StudentDto update(StudentDto student,int id);

    void delete(int id);

    StudentDto getById(int id);


    List<StudentDto> getStudentsByMajor(String major);
    StudentCourseDto getCoursesByStudentId(int id);
    List<StudentDto> getAll();
}
