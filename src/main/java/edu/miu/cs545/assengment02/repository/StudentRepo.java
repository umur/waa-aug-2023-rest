package edu.miu.cs545.assengment02.repository;

import edu.miu.cs545.assengment02.entity.Course;
import edu.miu.cs545.assengment02.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class StudentRepo {

    List<Student> students;

    public StudentRepo() {
        this.students = new ArrayList<>();
    }

    public List<Student> getAll(){

        var c1 = Course.builder().id(1)
                .name("FPP")
                .code(111).build();
        var c2 = Course.builder().id(2)
                .name("MPP")
                .code(222).build();
        var c3 = Course.builder().id(3)
                .name("WAP")
                .code(333).build();
        var c4 = Course.builder().id(4)
                .name("WAA")
                .code(444).build();


        this.students.add(new Student(1, "Jack", "Jak", "jack@gmail.com", "CS", Arrays.asList(c1,c2)));
        this.students.add(new Student(2, "Jill", "Jil", "jill@gmail.com", "Computer Science", Arrays.asList(c3,c4)));
      //  this.students.add(new Student(3, "John", "Jon", "jjohn@gmail.com", "Computer Science"));
       // this.students.add(new Student(4, "Jimmy", "Jim", "jimmy@gmail.com", "Computer Science"));
        return students;
    }


    public void update(Student student){

    }

    public Student getById(int id) {
        Optional<Student> first = students.stream().filter(student -> student.getId() == id).findFirst();
        if(first.isPresent()) return first.get();
         return null;
    }
}
