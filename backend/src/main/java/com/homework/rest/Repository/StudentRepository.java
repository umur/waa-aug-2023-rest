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
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(id.equals(student.getId())) {
                iterator.remove();
            }
        }
    }

    public void updateStudent(String id, Student updateStudent) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(id.equals(student.getId())) {
                student.setId(updateStudent.getId());
                student.setFirstName(updateStudent.getFirstName());
                student.setLastName(updateStudent.getLastName());
                student.setMajor(updateStudent.getMajor());
                student.setEmail(updateStudent.getEmail());
                student.setCourseTaken(updateStudent.getCourseTaken());
            }
        }
    }

}
