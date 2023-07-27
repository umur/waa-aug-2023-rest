package com.homework.rest.Controller;

import com.homework.rest.Dto.CourseDto;
import com.homework.rest.Dto.ResponseDto.CustomResponse;
import com.homework.rest.Entity.Course;
import com.homework.rest.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;



    @GetMapping
    public ResponseEntity<CustomResponse<List<CourseDto>>> getAllCourse() {
        List<CourseDto> courses = courseService.getCourse();
        if (courses.isEmpty()) {
            CustomResponse<List<CourseDto>> response = new CustomResponse<>("204","No Content" ,null);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        } else {
            CustomResponse<List<CourseDto>> response = new CustomResponse<>("200","Found Data" ,courses);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping
    public List<CourseDto> addCourse(@RequestBody CourseDto dto) {
        courseService.addCourse(dto);
        return courseService.getCourse();
    }

    @DeleteMapping("/{id}")
    public List<CourseDto> removeCourse(@PathVariable String id) {
        courseService.removeCourse(id);
        return courseService.getCourse();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public List<CourseDto> updateCourse(@PathVariable String id,@RequestBody CourseDto dto) {
        courseService.updateCourse(id,dto);
        return courseService.getCourse();
    }
}
