package org.haileab.lab2restfullwebservice.backend.controller;

import lombok.RequiredArgsConstructor;
import org.haileab.lab2restfullwebservice.backend.entity.Course;
import org.haileab.lab2restfullwebservice.backend.entity.Student;
import org.haileab.lab2restfullwebservice.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll(){
       return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable int id){
       return studentService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable int id){
       studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateOne(@PathVariable int id, @RequestBody Student student){
        studentService.update(id, student);
    }

    @GetMapping("/filterByMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major){
      return studentService.getStudentsByMajor(major);
    }


    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
       return studentService.getCoursesByStudentId(id);
    }
}


