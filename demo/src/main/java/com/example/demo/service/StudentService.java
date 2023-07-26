package com.example.demo.service;

import com.example.demo.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void saveStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    public List<StudentDto> getStudentsByMajor(String major);
    public Optional<StudentDto> getStudentById(int studentId);

}
