package com.example.assignment2.service.impl;

import com.example.assignment2.dto.CourseDto;
import com.example.assignment2.dto.StudentDto;
import com.example.assignment2.entity.Student;
import com.example.assignment2.entity.Course;
import com.example.assignment2.repository.StudentRepo;
import com.example.assignment2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    public void save(StudentDto student) {
//        List<StudentDto> studentDtoList = this.getAll();
//        if (studentDtoList.stream()
//                .filter(studentDto -> studentDto.getId() == student.getId()
//                ).toList().size() > 0) {
//            throw new RuntimeException();
//        }
        Student entity = new Student();
        entity.setId(student.getId());
        entity.setFirstName(student.getFirstName());
        entity.setLastName(student.getLastName());
        entity.setEmail(student.getEmail());
        entity.setCourseTaken(student.getCourseTaken());
        entity.setMajor(student.getMajor());

        studentRepo.save(entity);
    }

    @Override
    public List<StudentDto> getAll() {
        return this.studentToStudentDtoList(studentRepo.getAll());
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return this.studentToStudentDtoList(studentRepo.getStudentsByMajor(major));
    }

    @Override
    public void remove(int studentId) {
        studentRepo.remove(studentId);
    }

    @Override
    public void update(StudentDto student, int studentId) {
        studentRepo.update(student, studentId);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        System.out.printf("Test");
        List<CourseDto> courseDtoList = new ArrayList<>();
        List<Course> courses = studentRepo.getCoursesByStudentId(studentId);
        courses.forEach(course -> {
            CourseDto dto = new CourseDto(course.getId(), course.getName(), course.getCode());
            courseDtoList.add(dto);
        });

        return courseDtoList;
    }

    private List<StudentDto> studentToStudentDtoList(List<Student> studentList) {
        List<StudentDto> studentDtoList = new ArrayList<>();

        studentList.forEach(student -> {
            StudentDto dto = new StudentDto();
            dto.setId(student.getId());
            dto.setFirstName(student.getFirstName());
            dto.setLastName(student.getLastName());
            dto.setEmail(student.getEmail());
            dto.setCourseTaken(student.getCourseTaken());
            dto.setMajor(student.getMajor());

            studentDtoList.add(dto);
        });
        return studentDtoList;
    }

}
