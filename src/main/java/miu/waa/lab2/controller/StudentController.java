package miu.waa.lab2.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.lab2.dto.CourseDto;
import miu.waa.lab2.dto.StudentDto;
import miu.waa.lab2.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public Map<Integer, StudentDto> getAll(){
        return studentService.getAll();
    }

    @PostMapping
    public void create(@RequestBody StudentDto course){
        studentService.create(course);
    }

    @GetMapping("/{id}")
    public StudentDto read(@PathVariable int id){
        return studentService.read(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody StudentDto course, @PathVariable int id){
        studentService.update(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @GetMapping("/getStudentsByMajor/{major}")
    public ArrayList<StudentDto> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/getCoursesByStudentId/{id}")
    public ArrayList<CourseDto> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }
}
