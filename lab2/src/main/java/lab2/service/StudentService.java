package lab2.service;

import lab2.model.Course;
import lab2.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface StudentService {
    Student getStudentById(int id);
    List<Student> getAllStudents();
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);

}
