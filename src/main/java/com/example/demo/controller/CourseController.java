package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public void save(@RequestBody CourseDto course){
        courseService.save(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAll(){
        List<CourseDto> courseDtoList = courseService.getAll();
        return ResponseEntity.ok(courseDtoList);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable int id){
        CourseDto courseDto = courseService.getById(id);
        if(courseDto != null) return ResponseEntity.ok(courseDto);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public void update(@RequestBody CourseDto course, @PathVariable int id){
        courseService.update(course, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }
}
