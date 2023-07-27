package com.example.Lab2.RestFUL.Web.Services.Repository;

import com.example.Lab2.RestFUL.Web.Services.entity.Course;
import com.example.Lab2.RestFUL.Web.Services.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Repository
public class StudentRepository {
    private final Map<Long,Student>students=new HashMap<>();
    long studentId=1;

    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(studentId++);
        }
        students.put(student.getId(), student);
        return student;
    }


    public Student findById(Long id) {
        return students.get(id);
    }


    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }


    public void deleteById(Long id) {
        students.remove(id);
    }


    public List<Student> findByMajor(String major) {
        return students.values().stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }


    public List<Course> findCoursesByStudentId(Long studentId) {
        Student student = students.get(studentId);
        if (student != null) {
            return student.getCoursesTaken();
        }
        return new ArrayList<>();
    }
}

