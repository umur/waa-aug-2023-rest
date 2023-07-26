package com.example.Lab2.controllers;

import com.example.Lab2.dto.CourseDto;
import com.example.Lab2.services.implementation.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    private CourseServiceImpl courseService;

    @Autowired
    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.getAll();
    }

    @GetMapping(path = "/{id}")
    public CourseDto getById(@PathVariable int id) {
        return courseService.getById(id);
    }

    @PostMapping
    public void create(CourseDto courseDto) {
        courseService.create(courseDto);
    }

    @PutMapping
    public void update(CourseDto courseDto) {
        courseService.update(courseDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable int id) {
        courseService.deleteById(id);
    }
}
