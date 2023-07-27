package miu.waa.lab2.repository;

import miu.waa.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepo {
    Map<Integer, Student> students = new HashMap<>();

    public Student get(int id){
        return students.getOrDefault(id, null);
    }

    public void save(Student course) {
        students.putIfAbsent(course.getId(), course);
    }

    public Map<Integer, Student> getAll(){
        return students;
    }

    public void delete(int id){
        students.remove(id);
    }

    public void update(Student course){
        students.put(course.getId(), course);
    }
}
