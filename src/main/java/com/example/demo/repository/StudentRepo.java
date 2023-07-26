package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private final List<Student> students = new ArrayList<>();

    public Student save(Student student){
        students.add(student);
        return student;
    }

    public Student getStudentById(int id){
        return students.stream().filter(
                student -> student.getId() == id
        ).findFirst().orElse(null);
    }

    public List<Student> getStudents(){
        return students;
    }

    public void deleteStudentById(int id){
        students.removeIf(
                student -> student.getId() == id
        );
    }

    public List<Student> findByMajor(String major) {
        return students.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<String> findCoursesByStudentId(int studentId) {
        Student student = getStudentById(studentId);
        if (student != null) {
            return student.getCourseTaken();
        }
        return Collections.emptyList();
    }
}
