package com.example.assignment2.controller;

import com.example.assignment2.dto.CourseDto;

import com.example.assignment2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class CourseController {
    private final CourseService courseService;


    @PostMapping
    public void save(@RequestBody CourseDto course){
        System.out.println(course.getId());
        System.out.println(course.getName());
        courseService.save(course);
    }

    @GetMapping
    public List<CourseDto> getAll(){
        return courseService.getAll();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CourseDto courseDto, @PathVariable int id){
        courseService.update(courseDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.remove(id);
    }
}
