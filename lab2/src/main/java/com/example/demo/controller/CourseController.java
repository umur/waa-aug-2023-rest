package com.example.demo.controller;



import com.example.demo.dto.CourseDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping
    public CourseDto addCourse(@RequestBody CourseDto courseDto) {
        return courseService.save(courseDto);
    }

    @PutMapping("/{id}")
    public CourseDto updateCourse(@PathVariable int id, @RequestBody CourseDto courseDto) {
        return courseService.update(courseDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.delete(id);
    }

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable int id) {
        return courseService.getById(id);
    }

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.getAll();
    }

}
