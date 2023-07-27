package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();

    public void save(Student student){
        students.add(student);
    }

    public void update(Student student, int id) {
        students = students.stream().map(stu -> stu.getId() == id? student: stu).collect(Collectors.toList());
    }

    public void delete(int id) {
        students = students.stream().filter(stu -> stu.getId() != id).collect(Collectors.toList());
    }

    public List<Student> getAll(){
        return students;
    }
}
