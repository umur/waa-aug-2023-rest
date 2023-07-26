package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {

    @Autowired
    private studentService studentService;

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@RequestBody Student student){

        return studentService.delete(student);
    }

    @GetMapping("/filterByMajor")
    public List<Student> getStudentsByMajor(@RequestBody String major) {
        return studentService.getAllStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getStudentCoursesByStudentId(id);
    }
}
