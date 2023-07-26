package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    @Autowired
    private final StudentRepo studentRepo;
    @Override
    public void save(StudentDto student) {
        studentRepo.save(convertToEntity(student));
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepo.getAll();
        return convertToDtoList(students);
    }

    @Override
    public StudentDto getById(int id) {
        List<Student> students = studentRepo.getAll();
        Student studentEntity =  students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);

        return convertToDto(studentEntity);
    }

    @Override
    public void update(StudentDto studentDto, int id) {
        studentRepo.update(convertToEntity(studentDto), id);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<StudentDto> getByMajor(String major) {
        List<Student> students = studentRepo.getAll();
        List<Student> filterStudents =  students.stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());

        return convertToDtoList(filterStudents);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int id) {
        StudentDto studentDto = getById(id);
        return studentDto.getCoursesTaken();
    }

    private List<StudentDto> convertToDtoList(List<Student> students) {
         List<StudentDto> studentDtos = new ArrayList<>();
         for (Student student : students) {
             StudentDto studentDto = new StudentDto();
             studentDto.setId(student.getId());
             studentDto.setEmail(student.getEmail());
             studentDto.setMajor(student.getMajor());
             studentDto.setFirstName(student.getFirstName());
             studentDto.setLastName(student.getLastName());
             studentDto.setCoursesTaken(convertToCourseToCourseDto(student.getCoursesTaken()));
             studentDtos.add(studentDto);
         }
         return studentDtos;
    }

    private Student convertToEntity(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setEmail(studentDto.getEmail());
        student.setMajor(studentDto.getMajor());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setCoursesTaken(convertToCourseDtoToCourse(studentDto.getCoursesTaken()));

        return student;
    }

    private StudentDto convertToDto(Student student){
        if(student == null) return null;
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setEmail(student.getEmail());
        studentDto.setMajor(student.getMajor());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setCoursesTaken(convertToCourseToCourseDto(student.getCoursesTaken()));

        return studentDto;
    }

    static List<CourseDto> convertToCourseToCourseDto(List<Course> courses){
        if(courses == null) return null;
        List<CourseDto> courseTakenDto = courses.stream().map(course -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setCode(course.getCode());
            courseDto.setId(course.getId());
            courseDto.setName(course.getName());
            return courseDto;
        }).collect(Collectors.toList());

       return courseTakenDto;
    }

    private List<Course> convertToCourseDtoToCourse(List<CourseDto> courseDtoList){
        if(courseDtoList == null) return null;
        List<Course> courseTaken = courseDtoList.stream().map(courseDto -> {
            Course course = new Course();
            course.setCode(courseDto.getCode());
            course.setId(courseDto.getId());
            course.setName(courseDto.getName());
            return course;
        }).collect(Collectors.toList());
        return courseTaken;
    }
}
