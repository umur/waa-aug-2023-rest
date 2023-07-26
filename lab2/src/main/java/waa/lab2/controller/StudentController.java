package waa.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.lab2.dto.CourseDto;
import waa.lab2.dto.StudentDto;
import waa.lab2.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void save(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
    }

    @GetMapping
    public List<StudentDto> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{studentId}")
    public StudentDto getById(@PathVariable int studentId){
        return studentService.getById(studentId);
    }

    @PutMapping("/{studentId}")
    public void update(@PathVariable int studentId, @RequestBody StudentDto studentDto){
        studentService.update(studentId,studentDto);
    }

    @DeleteMapping("/{studentId}")
    public void deleteById(@PathVariable int studentId){
        studentService.deleteById(studentId);
    }

    @GetMapping("/filterStudentByMajor")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }

    @PostMapping("{studentId}/courses")
    public void addCourse(@PathVariable int studentId,@RequestBody CourseDto courseDto){
        studentService.addCourse(studentId,courseDto);
    }
}

