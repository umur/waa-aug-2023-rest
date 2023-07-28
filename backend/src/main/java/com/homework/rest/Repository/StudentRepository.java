package com.homework.rest.Repository;

import com.homework.rest.Entity.Student;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class StudentRepository {
    private static List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void removeStudent(String id) {
        System.out.println("here"+id);
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
            System.out.println(id.equals(student.getId()));
            if(id.equals(student.getId())) {
                iterator.remove();
            }
        }
    }

}
