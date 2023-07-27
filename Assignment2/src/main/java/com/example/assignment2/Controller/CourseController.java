package com.example.assignment2.Controller;

import com.example.assignment2.Entities.Course;
import com.example.assignment2.Entities.Student;
import com.example.assignment2.Services.CourseService;
import com.example.assignment2.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    //create
    @PostMapping
    public void save(@RequestBody Course course){
        courseService.save(course);
    }

    //read
    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    //update:
    @PutMapping("/{id}")
    public void update(@RequestBody Course course, @PathVariable int id){
        courseService.update(course, id);
    }

    //delete:
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        courseService.deleteById(id);
    }


}
