package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImplementation  implements StudentService {

    private final StudentRepo studentRepo;


    @Override
    public Student save(Student student) {
        Student stu = new Student();
        stu.setId(student.getId());
        stu.setFirstName(student.getFirstName());
        stu.setLastName(student.getLastName());
        stu.setEmail(student.getEmail());
        stu.setMajor(student.getMajor());
        List<String> stuCourses = student.getCourseTaken();
        for(int i=0; i< stuCourses.size(); i++){
            stu.getCourseTaken().add(stuCourses.get(i));
        }
        studentRepo.save(stu);
        return student;
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.getStudentById(id);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.getStudents();
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepo.deleteStudentById(id);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Student oldStudent = studentRepo.getStudentById(id);
        if (oldStudent != null) {
            oldStudent.setFirstName(student.getFirstName());
            oldStudent.setLastName(student.getLastName());
            oldStudent.setEmail(student.getEmail());
            oldStudent.setMajor(student.getMajor());
            List<String> stuCourses = student.getCourseTaken();
            oldStudent.getCourseTaken().clear();
            for(int i=0; i< stuCourses.size(); i++){
                oldStudent.getCourseTaken().add(stuCourses.get(i));
            }
//            oldStudent.setCourseTaken(student.getCourseTaken());
            return oldStudent;
        }
        return null;
    }

    @Override
    public List<Student> getStudentsByMajor(String major){
        return studentRepo.findByMajor(major);
    }

    @Override
    public List<String> getCourseByStudentId(int studentId){
        return studentRepo.findCoursesByStudentId(studentId);
    }

}
