package com.example.Lab2.controllers;

import com.example.Lab2.dto.CourseDto;
import com.example.Lab2.dto.StudentDto;
import com.example.Lab2.services.implementation.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping(path = "/{id}")
    public StudentDto getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @GetMapping(path = "/by-major")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping(path = "/courses-by-student/{id}")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

    @PostMapping
    public void create(StudentDto studentDto) {
        studentService.create(studentDto);
    }

    @PutMapping
    public void update(StudentDto studentDto) {
        studentService.update(studentDto);
    }

    @DeleteMapping
    public void deleteById(int id) {
        studentService.deleteById(id);
    }
}
