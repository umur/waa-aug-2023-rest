package com.Lab2ResfulWeb.lab2.Service;

import com.Lab2ResfulWeb.lab2.DTO.StudentDTO;
import com.Lab2ResfulWeb.lab2.Entiry.Course;
import com.Lab2ResfulWeb.lab2.Entiry.Student;

import java.util.List;

public interface IStudentService {

     void save(Student student);
    void Update( int id, Student student);

     List<Student> getAllStudent();

     List<Student> getStudentsByMajor(String major);
  public void delete(int id);
    public List<Course> getCoursesByStudentId(int id);

    public Student getById(int id);



}
