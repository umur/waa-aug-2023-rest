package com.example.assignment2.Controller;

import com.example.assignment2.Entities.Course;
import com.example.assignment2.Entities.Student;
import com.example.assignment2.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //create
    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    //read
    @GetMapping
    public List<Student> getAll(){
//        return userService.getAll();
        return studentService.getAll();
    }
    @GetMapping("/{major}")
    public List<Student> getStudentByMajor(@PathVariable String major){
        return studentService.getStudentByMajor(major);
    }
    @GetMapping("/courses/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    //update:
    @PutMapping("/{id}")
    public void update(@RequestBody Student student, @PathVariable int id){
        studentService.update(student, id);
    }

    //delete:
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        studentService.deleteById(id);
    }
/* ******** THIS IS NOT part of the project/assignment *******

    @GetMapping("/filterByAge")
    public List<Student> getAllByAge(@RequestParam int age){
        return null;
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id){
        return null;
    }
    @PutMapping("/{id}")
    public void update(@RequestBody UserDto user, @PathVariable int id){

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){

    }*/
}
