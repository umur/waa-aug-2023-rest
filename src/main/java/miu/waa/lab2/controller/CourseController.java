package miu.waa.lab2.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.lab2.dto.CourseDto;
import miu.waa.lab2.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public Map<Integer, CourseDto> getAll(){
        return courseService.getAll();
    }

    @PostMapping
    public void create(@RequestBody CourseDto course){
        courseService.create(course);
    }

    @GetMapping("/{id}")
    public CourseDto read(@PathVariable int id){
        return courseService.read(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CourseDto course, @PathVariable int id){
        courseService.update(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }

}
