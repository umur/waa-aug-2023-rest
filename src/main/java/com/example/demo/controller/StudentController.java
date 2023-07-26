package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student save(@RequestBody Student student) {
        studentService.save(student);
        return student;
//        Student createdStudent = studentService.save(student);
//        if (createdStudent != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getStudents();
    }

    @GetMapping("/major")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<String> getCoursesByStudentId(@PathVariable int studentId) {
        return studentService.getCourseByStudentId(studentId);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student course, @PathVariable int id) {
        return studentService.updateStudent(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }
}
