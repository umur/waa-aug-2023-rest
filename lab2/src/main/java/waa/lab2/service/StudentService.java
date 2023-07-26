package waa.lab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.lab2.domain.Course;
import waa.lab2.domain.Student;
import waa.lab2.dto.CourseDto;
import waa.lab2.dto.ModelToMapper;
import waa.lab2.dto.StudentDto;
import waa.lab2.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelToMapper modelToMapper;

    public List<StudentDto> getAll(){
        List<Student> students= studentRepository.getAll();
        List<StudentDto> studentDtos= new ArrayList<>();
        students.forEach(student ->{
            StudentDto studentDto= modelToMapper.studentToStudentDto(student, new StudentDto());
            studentDtos.add(studentDto);
        });
        return studentDtos;
    }
    public void save(StudentDto studentDto){
        Student student =modelToMapper.studentDtotoStudent(studentDto, new Student());
        studentRepository.save(student);
    }
    public void update(int id, StudentDto studentDto){
        Student student = studentRepository.getById(id);
        studentRepository.deleteById(id);
        student= modelToMapper.studentDtotoStudent(studentDto,student);
        studentRepository.save(student);
    }
    public StudentDto getById(int id){
        Student student = studentRepository.getById(id);
        return modelToMapper.studentToStudentDto(student,new StudentDto());
    }
    public void deleteById(int id){
        studentRepository.deleteById(id);
    }
    public List<StudentDto> getStudentsByMajor(String major){
        List<StudentDto> studentDtos= new ArrayList<>();
        studentRepository.getStudentsByMajor(major).forEach(student -> {
           studentDtos.add(modelToMapper.studentToStudentDto(student, new StudentDto()));
        });
        return  studentDtos;
    }
    public List<CourseDto> getCoursesByStudentId(int studentId){
        List<CourseDto> courseDtos= new ArrayList<>();
         studentRepository.getCoursesByStudentId(studentId).forEach(course -> {
             courseDtos.add(modelToMapper.courseToCourseDto(course,new CourseDto()));
         });
         return courseDtos;
    }
    public void addCourse(int studentId,CourseDto courseDto){
        Course course= modelToMapper.courseDtoToCourse(courseDto, new Course());
        studentRepository.addCourse(studentId,course);
    }

}
