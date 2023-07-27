package miu.waa.lab2.repository;

import miu.waa.lab2.entity.Course;
import miu.waa.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepo {
    Map<Integer, Student> students = new HashMap<>();
    public Map<Integer, Student> getAll(){
        return students;
    }
    public void create(Student student) {
        students.putIfAbsent(student.getId(), student);
    }
    public Student read(int id){
        return students.getOrDefault(id, new Student());
    }
    public void update(Student student){
        students.put(student.getId(), student);
    }
    public void delete(int id){
        students.remove(id);
    }

    public ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> result = new ArrayList<>();
        students.forEach((k,v)-> {
            if(v.getMajor().equals(major)){
                result.add(v);
            }
        });
        return result;
    }

    public ArrayList<Course> getCoursesByStudentId(int id){
        Student student = students.getOrDefault(id, new Student());
        return student.getCoursesTaken();
    }

}
