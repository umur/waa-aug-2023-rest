package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class courseController {

    @Autowired
    private courseService courseService;
    @PostMapping
    public void addCourse(@RequestBody Course course) {
        courseService.save(course);
    }

    @DeleteMapping
    public boolean deleteCourse(@RequestBody Course course) {
        return courseService.delete(course);
    }

    @GetMapping
    public List<Course> getAllCourse() {
        return courseService.getAll();
    }

}
