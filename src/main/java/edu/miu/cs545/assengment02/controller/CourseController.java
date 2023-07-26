package edu.miu.cs545.assengment02.controller;


import edu.miu.cs545.assengment02.dto.CourseDto;
import edu.miu.cs545.assengment02.entity.Course;
import edu.miu.cs545.assengment02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;


    @GetMapping
    public List<CourseDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CourseDto getOneById(@PathVariable int id){
        return service.getOneById(id);
    }

    @PostMapping
    public void create(@RequestBody CourseDto course){
        service.save(course);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CourseDto course, @PathVariable int id){
        service.update(course, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }




}
