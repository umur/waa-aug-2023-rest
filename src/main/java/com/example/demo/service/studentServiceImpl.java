package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class studentServiceImpl implements studentService {

    @Autowired
    private studentRepo studentRepo;
    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public boolean delete(Student student) {
        return studentRepo.delete(student);
    }

    @Override
    public List<Student> getAllStudentsByMajor(String major) {
        List<Student> studentList = studentRepo.getAll();
        return studentList.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

    @Override
    public List<Course> getStudentCoursesByStudentId(int id) {
        List<Student> studentList = studentRepo.getAll();

        List<Course> courseList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getId() == id)
                courseList = (student.getCoursesTaken());
        }
        return courseList;
    }
}
