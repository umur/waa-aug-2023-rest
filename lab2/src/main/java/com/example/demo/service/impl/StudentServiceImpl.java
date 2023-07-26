package com.example.demo.service.impl;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentCourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entitiy.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    public final StudentRepo studentRepo;

    @Override
    public void save(StudentDto student) {
        var entity = new Student();
        entity.setFirstName(student.getFirstName());
        entity.setLastName(student.getLastName());
        entity.setMajor(student.getMajor());
        entity.setCourseTaken(student.getCourseTaken());
        studentRepo.save(entity);
    }

    @Override
    public StudentDto update(StudentDto student,int id) {
        Student studentToUpdate = studentRepo.getById(id);
        if (studentToUpdate != null) {
            studentToUpdate.setFirstName(student.getFirstName());
            studentToUpdate.setLastName(student.getLastName());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setMajor(student.getMajor());
            studentToUpdate.setCourseTaken(student.getCourseTaken());
            studentRepo.save(studentToUpdate);
            return mapToDto(studentToUpdate);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public StudentDto getById(int id) {
        Student student = studentRepo.getById(id);
        if (student != null) {
            return mapToDto(student);
        }
        return null;
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<Student> studentsByMajor = studentRepo.getStudentsByMajor(major);
        return studentsByMajor.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentCourseDto getCoursesByStudentId(int id) {
        Student student = studentRepo.getById(id);
        if (student != null) {
            StudentCourseDto studentCourseDto = new StudentCourseDto();
            studentCourseDto.setId(student.getId());
            studentCourseDto.setCourseTaken(student.getCourseTaken());
            return studentCourseDto;
        }
        return null;
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> allStudents = studentRepo.getAll();
        return allStudents.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private StudentDto mapToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setMajor(student.getMajor());

        List<CourseDto> courseDtos = student.getCourseTaken().stream()
                .map(this::mapCourseToDto)
                .collect(Collectors.toList());


        studentDto.setCourseTaken(courseDtos);
        return studentDto;
    }

    private CourseDto mapCourseToDto(CourseDto course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setName(course.getName());
        courseDto.setCode(course.getCode());
        return courseDto;
    }

}
