package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.courseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseServiceImpl implements courseService {

    @Autowired
    private courseRepo studentRepo;
    @Override
    public void save(Course course) {
        studentRepo.save(course);
    }
    @Override
    public List<Course> getAll() {
        return studentRepo.getAll();
    }
    @Override
    public boolean delete(Course course){
        return studentRepo.delete(course);
    }
}
