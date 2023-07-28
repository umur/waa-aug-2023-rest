package com.homework.rest.Service;

import com.homework.rest.Dto.CoursesStudentDto;
import com.homework.rest.Dto.StudentDto;

import java.util.List;

public interface StudentService {
    public List<StudentDto> getStudents();
    public void addStudent(StudentDto studentDto);
    public void removeStudent(String id);
    public List<StudentDto> getStudentsByMajor(String major);
    public List<CoursesStudentDto> getCoursesByStudentId(String studentId);
}
