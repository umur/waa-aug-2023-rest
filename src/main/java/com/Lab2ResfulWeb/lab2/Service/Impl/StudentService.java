package com.Lab2ResfulWeb.lab2.Service.Impl;

import com.Lab2ResfulWeb.lab2.DTO.StudentDTO;
import com.Lab2ResfulWeb.lab2.Entiry.Course;
import com.Lab2ResfulWeb.lab2.Entiry.Student;
import com.Lab2ResfulWeb.lab2.Repository.StudentRepo;
import com.Lab2ResfulWeb.lab2.Service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
   @Autowired
    private StudentRepo studentRepo;


    @Override
    public void save(Student student) {
        studentRepo.Save(student);


    }

    @Override
    public void Update( int id, Student student) {
        studentRepo.update(id, student);

    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.getAll();
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);

    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepo.getCourseByStudentId(id);
    }

    @Override
    public Student getById(int id) {
        return studentRepo.getStudentById(id);
    }
}
