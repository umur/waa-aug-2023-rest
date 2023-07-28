package com.homework.rest.Controller;

import com.homework.rest.Dto.CoursesStudentDto;
import com.homework.rest.Dto.StudentDto;
import com.homework.rest.Entity.Student;
import com.homework.rest.Service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public List<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return studentService.getStudents();
    }

    @DeleteMapping("/{id}")
    public List<StudentDto> removeStudent(@PathVariable String id) {
        studentService.removeStudent(id);
        return studentService.getStudents();
    }

    @GetMapping("/major")
    public List<StudentDto> getStudentsByMajor(@PathParam("major") String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/courses/{id}")
    public List<CoursesStudentDto> getCoursesByStudentId(@PathVariable String id) {
        return studentService.getCoursesByStudentId(id);
    }

    @PutMapping("/{id}")
    public List<StudentDto> updateStudent(@PathVariable String id,@RequestBody StudentDto dto) {
        studentService.updateStudent(id,dto);
        return studentService.getStudents();
    }
}
