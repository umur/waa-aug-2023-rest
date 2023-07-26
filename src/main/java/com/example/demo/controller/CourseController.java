package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public Course update(@RequestBody Course course, @PathVariable int id) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.deleteCourseById(id);
    }
}
