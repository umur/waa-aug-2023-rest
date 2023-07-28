package com.homework.rest.Service.impl;

import com.homework.rest.Dto.CoursesStudentDto;
import com.homework.rest.Dto.StudentDto;
import com.homework.rest.Entity.Student;
import com.homework.rest.Repository.StudentRepository;
import com.homework.rest.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getStudents() {
        var entityList = studentRepository.getStudents();
        ArrayList<StudentDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> {
            var dto = new StudentDto();
            dto.setId(entity.getId());
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            dto.setEmail(entity.getEmail());
            dto.setMajor(entity.getMajor());
            dto.setCourseTaken(entity.getCourseTaken());
            dtoList.add(dto);
        });
        return dtoList;
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        var entity = new Student();
        entity.setId(studentDto.getId());
        entity.setFirstName(studentDto.getFirstName());
        entity.setLastName(studentDto.getLastName());
        entity.setEmail(studentDto.getEmail());
        entity.setMajor(studentDto.getMajor());
        entity.setCourseTaken(studentDto.getCourseTaken());
        studentRepository.addStudent(entity);
    }

    @Override
    public void removeStudent(String id) {
        studentRepository.removeStudent(id);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var entityList = studentRepository.getStudents();
        List<StudentDto> dtoList = new ArrayList<>();
        var dto = new StudentDto();
        entityList.forEach(entity -> {
            if(major.equals(entity.getMajor())) {
                dto.setId(entity.getId());
                dto.setFirstName(entity.getFirstName());
                dto.setLastName(entity.getLastName());
                dto.setEmail(entity.getEmail());
                dto.setMajor(entity.getMajor());
                dto.setCourseTaken(entity.getCourseTaken());
                dtoList.add(dto);
            }
        });
        return dtoList;
    }

    @Override
    public List<CoursesStudentDto> getCoursesByStudentId(String studentId) {
        var entityList = studentRepository.getStudents();
        List<CoursesStudentDto> dtoList = new ArrayList<>();
        var dto = new CoursesStudentDto();
        entityList.forEach(entity -> {
            if(studentId.equals(entity.getId())) {
                dto.setCourses(entity.getCourseTaken());
            }
            dtoList.add(dto);
        });
        return dtoList;
    }

    public void updateStudent(String id,StudentDto studentDto) {
        var entity = new Student();
        entity.setId(studentDto.getId());
        entity.setFirstName(studentDto.getFirstName());
        entity.setLastName(studentDto.getLastName());
        entity.setMajor(studentDto.getMajor());
        entity.setEmail(studentDto.getEmail());
        entity.setCourseTaken(studentDto.getCourseTaken());
        studentRepository.updateStudent(id,entity);
    }
}
