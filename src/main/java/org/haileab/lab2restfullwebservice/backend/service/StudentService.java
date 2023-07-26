package org.haileab.lab2restfullwebservice.backend.service;

import org.haileab.lab2restfullwebservice.backend.entity.Course;
import org.haileab.lab2restfullwebservice.backend.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    void save(Student student);

    void delete(int id);

    void update(int id, Student student);

    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int id);

    Student getById(int id);
}

