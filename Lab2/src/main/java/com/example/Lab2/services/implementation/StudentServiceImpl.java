package com.example.Lab2.services.implementation;

import com.example.Lab2.dto.CourseDto;
import com.example.Lab2.dto.StudentDto;
import com.example.Lab2.entities.Course;
import com.example.Lab2.entities.Student;
import com.example.Lab2.repositories.StudentRepo;
import com.example.Lab2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> studentList= studentRepo.getAll();
        return convertToStudentDtoList(studentList);
    }

    @Override
    public StudentDto getById(int id) {
        Student student= studentRepo.getById(id);

        StudentDto studentDto= new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setMajor(student.getMajor());
        studentDto.setCoursesTaken(student.getCoursesTaken());

        return studentDto;
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<Student> studentList= studentRepo.getStudentsByMajor(major);
        return convertToStudentDtoList(studentList);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        List<Course> courseList= studentRepo.getCoursesByStudentId(studentId);
        List<CourseDto> courseDtos= new ArrayList<>();

        courseList.forEach(course -> {
            CourseDto courseDto= new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setCode(course.getCode());
            courseDto.setName(course.getName());
            courseDtos.add(courseDto);
        });

        return courseDtos;
    }

    @Override
    public void create(StudentDto studentDto) {
        Student student= new Student();
        student= setStudent(student, studentDto);
        studentRepo.create(student);
    }

    @Override
    public void update(StudentDto studentDto) {
        Student student= studentRepo.getById(studentDto.getId());
        student= setStudent(student, studentDto);
        studentRepo.update(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepo.deleteById(id);
    }

    private Student setStudent(Student student, StudentDto studentDto) {
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setMajor(studentDto.getMajor());
        student.setEmail(studentDto.getEmail());
        student.setCoursesTaken(studentDto.getCoursesTaken());

        return student;
    }

    private List<StudentDto> convertToStudentDtoList(List<Student> studentList) {
        List<StudentDto> studentDtos= new ArrayList<>();

        studentList.forEach(student -> {
            StudentDto studentDto= new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setFirstName(student.getFirstName());
            studentDto.setLastName(student.getLastName());
            studentDto.setEmail(student.getEmail());
            studentDto.setMajor(student.getMajor());
            studentDto.setCoursesTaken(student.getCoursesTaken());
            studentDtos.add(studentDto);
        });

        return studentDtos;
    }
}
