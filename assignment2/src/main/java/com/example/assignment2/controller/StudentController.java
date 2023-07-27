package com.example.assignment2.controller;

import com.example.assignment2.dto.CourseDto;
import com.example.assignment2.dto.StudentDto;
import com.example.assignment2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public void save(@RequestBody StudentDto student) {
        studentService.save(student);
    }

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody StudentDto student, @PathVariable int id) {
        studentService.update(student, id);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.remove(id);
    }

    @GetMapping("/getStudentsByMajor")
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

}
