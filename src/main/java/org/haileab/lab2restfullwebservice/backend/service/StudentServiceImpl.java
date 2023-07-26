package org.haileab.lab2restfullwebservice.backend.service;

import lombok.RequiredArgsConstructor;
import org.haileab.lab2restfullwebservice.backend.repository.StudentsRepo;
import org.haileab.lab2restfullwebservice.backend.entity.Course;
import org.haileab.lab2restfullwebservice.backend.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{
    private StudentsRepo studentsRepo;

    @Autowired
    public StudentServiceImpl(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    @Override
    public List<Student> getAll() {
        return studentsRepo.getAll();
    }

    @Override
    public void save(Student student) {
        studentsRepo.save(student);
    }

    @Override
    public void delete(int id) {
        studentsRepo.delete(id);
    }

    @Override
    public void update(int id, Student student) {
        studentsRepo.update(id, student);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentsRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return getCoursesByStudentId(id);
    }

    @Override
    public Student getById(int id) {
        return studentsRepo.getById(id);
    }
}
