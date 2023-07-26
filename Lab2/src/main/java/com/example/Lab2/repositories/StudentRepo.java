package com.example.Lab2.repositories;

import com.example.Lab2.entities.Course;
import com.example.Lab2.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    private List<Student> students;

    public StudentRepo() {
        students= new ArrayList<>();
    }

    public List<Student> getAll() {
        return students;
    }

    public Student getById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getStudentsByMajor(String major) {
        List<Student> studentList= students.stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());
        return studentList;
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        Student findStudent= getById(studentId);
        return findStudent.getCoursesTaken();
    }

    public void create(Student student) {
        students.add(student);
    }

    public void update(Student student) {
        Student studentToUpdate= getById(student.getId());
        if (studentToUpdate != null) {
            studentToUpdate.setFirstName(student.getFirstName());
            studentToUpdate.setLastName(student.getLastName());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setMajor(student.getMajor());
            studentToUpdate.setCoursesTaken(student.getCoursesTaken());
        }
    }

    public void deleteById(int id) {
        Student studentToDelete= getById(id);
        students.remove(studentToDelete);
    }
}
