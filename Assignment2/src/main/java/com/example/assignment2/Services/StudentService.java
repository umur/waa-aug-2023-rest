package com.example.assignment2.Services;

import com.example.assignment2.Entities.Course;
import com.example.assignment2.Entities.Student;
import com.example.assignment2.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void update(Student student, int id) {
        studentRepository.update(student, id);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentByMajor(String major) {
        return studentRepository.getStudentByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }
}
