package com.example.demo.controller;


import com.example.demo.dto.StudentCourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.dto.StudentMajorDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @PostMapping
    public void save(@RequestBody StudentDto student){
        studentService.save(student);
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@RequestBody StudentDto student, @PathVariable int id){
        return studentService.update(student, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.delete(id);
    }

    @GetMapping
    public List<StudentDto> getAllStudent(){
        return studentService.getAll();
    }

    @GetMapping("/major/{major}")
    public List<StudentDto> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public StudentCourseDto getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }
}
