package com.homework.rest.Repository;

import com.homework.rest.Entity.Student;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void removeStudent(String id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(id.equals(student.getId())) {
                iterator.remove();
            }
        }
    }

}
