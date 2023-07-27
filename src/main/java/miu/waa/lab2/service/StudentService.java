package miu.waa.lab2.service;

import miu.waa.lab2.dto.CourseDto;
import miu.waa.lab2.dto.StudentDto;

import java.util.ArrayList;
import java.util.Map;

public interface StudentService {
    Map<Integer, StudentDto> getAll();
    void create(StudentDto course);
    StudentDto read(int id);
    void update(StudentDto course);
    void delete(int id);

    ArrayList<StudentDto> getStudentsByMajor(String major);

    ArrayList<CourseDto> getCoursesByStudentId(int id);
}
