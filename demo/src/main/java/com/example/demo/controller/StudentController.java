package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public void save(@RequestBody StudentDto studentDto){

        studentService.saveStudent(studentDto);
    }

    @GetMapping
    public List<StudentDto> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping("/filterByMajor")
    public List<StudentDto>getAllByMajor( String major){
        return studentService.getStudentsByMajor(major);
    }
}
