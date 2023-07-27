package com.Lab2ResfulWeb.lab2.Repository;

import com.Lab2ResfulWeb.lab2.DTO.StudentDTO;
import com.Lab2ResfulWeb.lab2.Entiry.Course;
import com.Lab2ResfulWeb.lab2.Entiry.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private List<Student> studentList= new ArrayList();

    public  void Save(Student student){
        studentList.add(student);
    }
    public List<Student> getAll(){
        return studentList;
    }
    public Student getStudentById(int id){
        for(Student s: studentList){
            if(s.getId()==id) return s;
        }
        return null;
    }
public List<Course> getCourseByStudentId(int id){
        for(Student s:studentList){
            if(s.getId()==id ) {
                return s.getCourselist();}
        }
        return null;
}
    public void deleteById(int id){
        studentList.forEach((s)->{
            if(s.getId()==(id)) studentList.remove(s);
        });

    }

   public List<Student> getStudentsByMajor(String major){
        List<Student> studentMajor = new ArrayList<>();
       studentList.forEach(s->{
           if(s.getMajor().equals(major)) studentMajor.add(s);

       });
       return studentMajor;
   }

  public void update(int id, Student student){
        studentList.forEach(s->{
            if(s.getId()==(id)){
                s=student;
            }
        });
   }

}
