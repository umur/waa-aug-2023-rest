package waa.lab2.repository;

import org.springframework.stereotype.Repository;
import waa.lab2.domain.Course;
import waa.lab2.domain.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private static List<Student> studentList=new ArrayList<>();

    public void save(Student student){
        studentList.add(student);
    }
    public List<Student> getAll(){
        return studentList;
    }
    public Student getById(int id){
       return  studentList.stream().filter(student -> student.getStudentId()==id)
                          .findFirst()
                           .orElse(null);
    }
    public void deleteById(int id){
        Student student=studentList.stream().filter(st -> st.getStudentId()==id)
                                    .findFirst()
                                    .orElse(null);
        studentList.remove(student);
    }
    public List<Student> getStudentsByMajor(String major){
        return studentList.stream()
                .filter(student->student.getMajor().equalsIgnoreCase(major))
                .toList();
    }
    public  List<Course> getCoursesByStudentId(int studentId){
        return studentList.stream()
                .filter(student->student.getStudentId()==studentId)
                .map(Student::getCoursesTaken)
                .findFirst()
                .orElse(null);
    }
    public void addCourse(int studentId, Course course){
        Student student=studentList.stream().filter(st -> st.getStudentId()==studentId)
                .findFirst()
                .orElse(null);
        assert student != null;
        student.addCourse(course);

    }





}
