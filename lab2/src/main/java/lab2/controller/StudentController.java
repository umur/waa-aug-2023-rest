package lab2.controller;

import lab2.model.Course;
import lab2.model.Student;
import lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent != null) {
            student.setId(id);
            studentService.updateStudent(student);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent != null) {
            studentService.deleteStudentById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable String major) {
        List<Student> studentsByMajor = studentService.getStudentsByMajor(major);
        return new ResponseEntity<>(studentsByMajor, HttpStatus.OK);
    }


    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable int studentId) {
        List<Course> coursesByStudent = studentService.getCoursesByStudentId(studentId);
        return new ResponseEntity<>(coursesByStudent, HttpStatus.OK);
    }

}
