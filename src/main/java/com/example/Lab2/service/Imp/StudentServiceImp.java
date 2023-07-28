package com.example.Lab2.service.Imp;

import com.example.Lab2.entity.Course;
import com.example.Lab2.entity.Student;
import com.example.Lab2.repository.StudentRepo;
import com.example.Lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    // Add a new student
    public void addStudent(Student student) {
        studentRepo.addStudent(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    // Get a student by ID
    public Student getStudentById(int studentId) {
        return studentRepo.getStudentById(studentId);
    }

    // Update an existing student
    public void updateStudent(Student updatedStudent, int id) {
        studentRepo.updateStudent(updatedStudent, id);
    }

    // Delete a student by ID
    public void deleteStudent(int studentId) {
        studentRepo.deleteStudent(studentId);
    }

    // Get students by major
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    // Get courses by student ID
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}

