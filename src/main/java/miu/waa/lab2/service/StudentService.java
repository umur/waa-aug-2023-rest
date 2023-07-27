package miu.waa.lab2.service;

import miu.waa.lab2.dto.StudentDto;

import java.util.Map;

public interface StudentService {
    StudentDto get(int id);
    void save(StudentDto course);
    Map<Integer, StudentDto> getAll();
    void delete(int id);
    void update(StudentDto course);
}
