package com.Lab2.assignment2.service.impl;

import com.Lab2.assignment2.dto.StudentDto;
import com.Lab2.assignment2.entity.Course;
import com.Lab2.assignment2.entity.Student;
import com.Lab2.assignment2.repository.StudentRepo;
import com.Lab2.assignment2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class StudentServiceImp implements StudentService{

    private StudentRepo studentRepo;
    @Autowired
    public StudentServiceImp (StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }
    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void delete(int studentId) {
        studentRepo.delete(studentId);
    }

    @Override
    public void update(Student student, int studentId) {
        studentRepo.update(student, studentId);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public Student getById(int studentId) {
        Optional<Student> studentOptional = studentRepo.getById(studentId);

        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        throw new RuntimeException("Can not find student Id");
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
