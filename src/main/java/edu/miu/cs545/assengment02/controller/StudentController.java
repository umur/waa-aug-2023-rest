package edu.miu.cs545.assengment02.controller;

import edu.miu.cs545.assengment02.dto.CourseDto;
import edu.miu.cs545.assengment02.dto.CoursesStudentDto;
import edu.miu.cs545.assengment02.dto.StudentDto;
import edu.miu.cs545.assengment02.entity.Student;
import edu.miu.cs545.assengment02.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<StudentDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/major")
    public List<StudentDto> getByMajor(@RequestParam String major){
        return service.getByMajor(major);
    }

    @GetMapping("/courses")
    public List<CourseDto> getCoursesByStudentId(@RequestParam int id){
        return service.getCoursesByStudentId(id);
    }

}
