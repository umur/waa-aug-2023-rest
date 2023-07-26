package com.example.demo.service.impl;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public void saveStudent(StudentDto studentDto) {
        Student studentEntity = new Student();
        studentEntity.setId(studentDto.getId());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setMajor(studentDto.getMajor());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setCoursesTaken(studentDto.getCoursesTaken());

        studentRepository.saveStudent(studentEntity);

    }

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student>studentEntityList = studentRepository.getAllStudents();
        List<StudentDto>studentDtoList = new ArrayList<>();
        studentEntityList.forEach(entity->{
            var dto = new StudentDto();
            dto.setMajor(entity.getMajor());
            dto.setEmail(entity.getEmail());
            dto.setId(entity.getId());
            dto.setLastName(entity.getLastName());
            dto.setFirstName(entity.getFirstName());
            dto.setCoursesTaken(entity.getCoursesTaken());
            studentDtoList.add(dto);
        });
        System.out.println("about to return getAllStudents");
        return studentDtoList;
    }

public List<StudentDto> getStudentsByMajor(String major){
        List<StudentDto>studentList = getAllStudents();
    System.out.println("filtering by major");
       return studentList.stream()
                .filter(studentDto -> studentDto.getMajor().equals(major))
               .toList();
}

    public Optional<StudentDto> getStudentById(int id){

        List<StudentDto>studentList = getAllStudents();
        System.out.println("filtering by id");
        return studentList.stream()
                .filter(studentDto -> studentDto.getId()==id)
                .findFirst();

    }


}
