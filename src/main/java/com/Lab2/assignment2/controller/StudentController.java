package com.Lab2.assignment2.controller;

import com.Lab2.assignment2.entity.Course;
import com.Lab2.assignment2.entity.Student;
import com.Lab2.assignment2.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @PutMapping("/{studentId}")
    public void update(@RequestBody Student student, @PathVariable int studentId){
        studentService.update(student, studentId);
    }

    @DeleteMapping("/{studentId}")
    public void delete (@PathVariable int studentId){
        studentService.delete(studentId);
    }

    @GetMapping
    public List<Student> getAll (){
        return studentService.getAll();
    }

    @GetMapping("/{studentId}")
    public Student getById (@PathVariable int studentId){
        return studentService.getById(studentId);
    }

    @GetMapping("/major")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }
}
