package lab2.repository;

import lab2.model.Course;
import lab2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepo {
    private final Map<Integer, Student> studentsMap = new HashMap<>();


    public Student findById(int id) {
        return studentsMap.get(id);
    }


    public List<Student> findAll() {
        return new ArrayList<>(studentsMap.values());
    }


    public void save(Student student) {
        studentsMap.put(student.getId(), student);
    }


    public void update(Student student) {
        studentsMap.put(student.getId(), student);
    }


    public void deleteById(int id) {
        studentsMap.remove(id);
    }


    public List<Student> findByMajor(String major) {
        List<Student> studentsByMajor = new ArrayList<>();
        for (Student student : studentsMap.values()) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                studentsByMajor.add(student);
            }
        }
        return studentsByMajor;
    }


    public List<Course> findCoursesByStudentId(int studentId) {
        Student student = studentsMap.get(studentId);
        if (student != null) {
            return student.getCoursesTaken();
        }
        return new ArrayList<>();
    }
}
