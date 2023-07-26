package com.Tsinat.lab2restfullwebservice.backend.service;

import com.Tsinat.lab2restfullwebservice.backend.entity.Course;
import com.Tsinat.lab2restfullwebservice.backend.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Student student) {

    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return null;
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return null;
    }

    @Override
    public Student getById(int id) {
        return null;
    }
}
