package com.example.assignment2.repository;

import com.example.assignment2.dto.StudentDto;
import com.example.assignment2.entity.Course;
import com.example.assignment2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();

    static {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "Course1", "CO1"));
        courses.add(new Course(2, "Course2", "CO2"));
        courses.add(new Course(3, "Course3", "CO3"));
        courses.add(new Course(4, "Course4", "CO4"));
        courses.add(new Course(5, "Course5", "CO5"));

        students.add(new Student(1, "First1", "Last1", "first1@Email.com", "Computer Science", courses));
        students.add(new Student(2, "First2", "Last2", "first2@Email.com", "Computer Science", courses));
        students.add(new Student(3, "First3", "Last3", "first3@Email.com", "Computer Science", courses));
        students.add(new Student(4, "First4", "Last4", "first4@Email.com", "Arts", courses));
        students.add(new Student(5, "First5", "Last5", "first5@Email.com", "Arts", courses));
    }

    public void save(Student student) {
        students.add(student);
    }

    public void remove(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }

    public void update(StudentDto studentDto, int studentId) {
        students.forEach(student -> {
            if (student.getId() == studentId) {
                student.setFirstName(studentDto.getFirstName());
                student.setLastName(studentDto.getLastName());
                student.setMajor(studentDto.getMajor());
                student.setEmail(studentDto.getEmail());
                student.setCourseTaken(studentDto.getCourseTaken());
            }
        });
    }

    public List<Student> getAll() {
        return students;
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        List<Course> courses = students.stream()
                .filter(student -> student.getId() == studentId)
                .map(student -> student.getCourseTaken())
                .flatMap(List::stream)
                .toList();
        return courses;
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .toList();
    }

}
