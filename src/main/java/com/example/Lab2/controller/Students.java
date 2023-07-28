package com.example.Lab2.controller;

import com.example.Lab2.entity.Course;
import com.example.Lab2.entity.Student;
import com.example.Lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class Students {
    @Autowired
    private StudentService studentService;


    // Add a new student
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully");
    }

    // Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    // Update an existing student
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int studentId, @RequestBody Student updatedStudent) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            updatedStudent.setId(studentId);
            studentService.updateStudent(updatedStudent, studentId);
            return ResponseEntity.ok("Student updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            studentService.deleteStudent(studentId);
            return ResponseEntity.ok("Student deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // Get students by major
    @GetMapping("/major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable("major") String major) {
        List<Student> students = studentService.getStudentsByMajor(major);
        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }

    // Get courses by student ID
    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable("id") int studentId) {
        List<Course> courses = studentService.getCoursesByStudentId(studentId);
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses);
    }
}
