package lab2.controller;

import lab2.model.Course;
import lab2.model.Student;
import lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    public void addStudent(Student student) {
        studentService.addStudent(student);
    }
    public Student getStudentById(int id) {
        return studentService.getStudentById(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentService.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }


}
