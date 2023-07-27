package miu.waa.lab2.repository;

import miu.waa.lab2.entity.Student;
import org.springframework.stereotype.Repository;

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


}
