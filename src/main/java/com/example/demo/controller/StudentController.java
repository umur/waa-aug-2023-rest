package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void save(@RequestBody StudentDto student){
        studentService.save(student);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        List<StudentDto> studentDtoList = studentService.getAll();
        return ResponseEntity.ok(studentDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable int id) {
        StudentDto studentDto = studentService.getById(id);
        if (studentDto != null) return ResponseEntity.ok(studentDto);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody StudentDto student) {
        studentService.update(student, id);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }


    @GetMapping("/major/{major}")
    public ResponseEntity<List<StudentDto>> getStudentsByMajor(@PathVariable String major){
        return ResponseEntity.ok(studentService.getByMajor(major));
    }

    @GetMapping("/courses/{studentId}")
    public ResponseEntity<List<CourseDto>> getCoursesByStudentId(@PathVariable int studentId){
        return ResponseEntity.ok(studentService.getCoursesByStudentId(studentId));
    }

}
