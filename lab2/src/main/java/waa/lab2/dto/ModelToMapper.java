package waa.lab2.dto;

import org.springframework.stereotype.Component;
import waa.lab2.domain.Course;
import waa.lab2.domain.Student;

@Component
public class ModelToMapper {
    public Student studentDtotoStudent(StudentDto studentDto, Student student){
        student.setStudentId(studentDto.getStudentId());
        student.setEmail(studentDto.getEmail());
        student.setMajor(studentDto.getMajor());
        student.setLastName(studentDto.getLastName());
        student.setFirstName(studentDto.getFirstName());
//        student.setCoursesTaken(studentDto.getCoursesTaken());
        return  student;
    }
    public StudentDto studentToStudentDto(Student student,StudentDto studentDto){
        studentDto.setStudentId(student.getStudentId());
        studentDto.setEmail(student.getEmail());
        studentDto.setMajor(student.getMajor());
        studentDto.setLastName(student.getLastName());
        studentDto.setFirstName(student.getFirstName());
//        studentDto.setCoursesTaken(student.getCoursesTaken());
        return studentDto;
    }
    public CourseDto courseToCourseDto(Course course,CourseDto courseDto){
        courseDto.setCourseId(course.getCourseId());
        courseDto.setCode(course.getCode());
        courseDto.setName(course.getName());
        return courseDto;
    }
    public Course courseDtoToCourse(CourseDto courseDto,Course course){
        course.setCourseId(courseDto.getCourseId());
        course.setCode(courseDto.getCode());
        course.setName(courseDto.getName());
        return course;
    }

}
