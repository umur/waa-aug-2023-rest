package lab2.service.impl;

import lab2.model.Course;
import lab2.model.Student;
import lab2.repository.StudentRepo;
import lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class studentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student getStudentById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.update(student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.findByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return null;
    }
}
