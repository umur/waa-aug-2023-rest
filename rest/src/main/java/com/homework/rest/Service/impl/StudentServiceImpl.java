package com.homework.rest.Service.impl;

import com.homework.rest.Dto.StudentDto;
import com.homework.rest.Entity.Student;
import com.homework.rest.Repository.StudentRepository;
import com.homework.rest.Service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

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
}
