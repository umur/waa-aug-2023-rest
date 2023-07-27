package miu.waa.lab2.service;

import miu.waa.lab2.dto.StudentDto;

import java.util.Map;

public interface StudentService {
    Map<Integer, StudentDto> getAll();
    void create(StudentDto course);
    StudentDto read(int id);
    void update(StudentDto course);
    void delete(int id);

}
