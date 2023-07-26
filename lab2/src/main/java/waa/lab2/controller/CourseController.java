package waa.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.lab2.dto.CourseDto;
import waa.lab2.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDto> getAll(){
        return courseService.getAll();
    }
    @PostMapping
    public void save(@RequestBody CourseDto courseDto){
        courseService.save(courseDto);
    }
    @PutMapping("/{courseId}")
    public void update(@PathVariable int courseId, @RequestBody CourseDto courseDto){
        courseService.update(courseId,courseDto);
    }
    @GetMapping("/{courseId}")
    public CourseDto getById(@PathVariable int courseId){
       return courseService.getById(courseId);
    }
    @DeleteMapping("/{courseId}")
    public void deleteById(@PathVariable int courseId){
        courseService.deleteById(courseId);
    }



}
