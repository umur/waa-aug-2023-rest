package com.example.Assignment2.controller;

import com.example.Assignment2.dto.CourseDto;
import com.example.Assignment2.entity.Course;
import com.example.Assignment2.service.Impl.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceImpl courseServiceImpl;


    @GetMapping
    public List<CourseDto> getAll(){
        return courseServiceImpl.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Course> getCoursesById(@PathVariable int id){
        return courseServiceImpl.getCourseById(id);
    }


    @PostMapping
    public void save(@RequestBody CourseDto course) {
        courseServiceImpl.save(course);
    }

   @PutMapping("{id}")
    public void update(@RequestBody Course course,@PathVariable int id){
       Optional<Course> existingCourse=courseServiceImpl.getCourseById(id);
        if(existingCourse !=null){
            courseServiceImpl.delete(id);
            course.setId(course.getId());
            course.setName(course.getName());
            course.setCode(course.getCode());
           courseServiceImpl.update(course);

        }

   }
   @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
       courseServiceImpl.delete(id);

   }


}
