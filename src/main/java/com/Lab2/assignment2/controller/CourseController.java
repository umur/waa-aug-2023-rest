package com.Lab2.assignment2.controller;

import com.Lab2.assignment2.entity.Course;
import com.Lab2.assignment2.service.CourseService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")

public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping
    public void save (@RequestBody Course course){
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Course course, @PathVariable int id){
        courseService.update(course, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id){
        return courseService.getById(id);
    }


}
