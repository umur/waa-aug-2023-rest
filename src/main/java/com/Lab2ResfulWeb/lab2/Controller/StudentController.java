package com.Lab2ResfulWeb.lab2.Controller;

import com.Lab2ResfulWeb.lab2.Entiry.Course;
import com.Lab2ResfulWeb.lab2.Entiry.Student;
import com.Lab2ResfulWeb.lab2.Service.Impl.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

  private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void create(@RequestBody Student student){
        studentService.save(student);

    }
    @GetMapping
    public List<Student> getAllStuddents(){
        return studentService.getAllStudent();

    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable  int id){
        return studentService.getById(id);
    }
    @GetMapping("/{filterMajor}")
    public List<Student> getStudentByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }
    @GetMapping("/{id}/courses")
    public List<Course> getCouseByStudentId(int studentId){
        return studentService.getCoursesByStudentId(studentId);

    }
    @DeleteMapping("/{id}")
    public  void deleteById(@PathVariable int Id){
        studentService.delete(Id);

    }
    @PutMapping("/{id}")
    public void Update(@PathVariable int Id, @RequestBody  Student  student){
        studentService.Update(Id, student);
    }

}
