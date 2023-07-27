package miu.waa.lab2.service;

import lombok.RequiredArgsConstructor;
import miu.waa.lab2.dto.CourseDto;
import miu.waa.lab2.dto.StudentDto;
import miu.waa.lab2.entity.Student;
import miu.waa.lab2.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    public Map<Integer, StudentDto> getAll() {
        Map<Integer, Student> studentsMap = studentRepo.getAll();
        Map<Integer, StudentDto> dtoMap =  new HashMap<>();
        studentsMap.forEach((k, c) -> {
            var dto = new StudentDto();
            dto.setId(c.getId());
            dto.setFirstName(c.getFirstName());
            dto.setLastName(c.getLastName());
            dto.setEmail(c.getEmail());
            dto.setMajor(c.getMajor());
            dto.setCoursesTaken(c.getCoursesTaken());
            dtoMap.put(k,dto);
        });
        return dtoMap;
    }

    @Override
    public void create(StudentDto c) {
        Student entity = new Student();
        entity.setId(c.getId());
        entity.setFirstName(c.getFirstName());
        entity.setLastName(c.getLastName());
        entity.setEmail(c.getEmail());
        entity.setMajor(c.getMajor());
        entity.setCoursesTaken(c.getCoursesTaken());
        studentRepo.create(entity);
    }

    @Override
    public StudentDto read(int id) {
        Student student = studentRepo.read(id);
        StudentDto studentDto=new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setMajor(student.getMajor());
        studentDto.setCoursesTaken(student.getCoursesTaken());
        return studentDto;
    }

    @Override
    public void update(StudentDto s) {
        Student entity = new Student();
        entity.setId(s.getId());
        entity.setFirstName(s.getFirstName());
        entity.setLastName(s.getLastName());
        entity.setEmail(s.getEmail());
        entity.setMajor(s.getMajor());
        entity.setCoursesTaken(s.getCoursesTaken());
        studentRepo.update(entity);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }
}
