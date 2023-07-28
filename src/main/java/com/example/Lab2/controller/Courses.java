package com.example.Lab2.controller;

import com.example.Lab2.entity.Course;
import com.example.Lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class Courses {
    @Autowired
    private CourseService courseService;

    // Add a new course
    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Course added successfully");
    }
    // Get all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses);
    }

    // Get a course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") int courseId) {
        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.notFound().build();
    }

    // Update an existing course
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable("id") int courseId, @RequestBody Course updatedCourse) {
        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            updatedCourse.setId(courseId);
            courseService.updateCourse(updatedCourse, courseId);
            return ResponseEntity.ok("Course updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a course by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") int courseId) {
        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            courseService.deleteCourse(courseId);
            return ResponseEntity.ok("Course deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
