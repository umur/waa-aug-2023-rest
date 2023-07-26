package waa.lab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.lab2.domain.Course;
import waa.lab2.domain.Student;
import waa.lab2.dto.CourseDto;
import waa.lab2.dto.ModelToMapper;
import waa.lab2.dto.StudentDto;
import waa.lab2.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelToMapper modelToMapper;

    public List<CourseDto> getAll(){
        List<Course> courses= courseRepository.getAll();
        List<CourseDto> courseDtos= new ArrayList<>();
        courses.forEach(course ->{
            CourseDto courseDto= modelToMapper.courseToCourseDto(course, new CourseDto());
            courseDtos.add(courseDto);
        });
        return courseDtos;
    }
    public void save(CourseDto courseDto){
        Course course =modelToMapper.courseDtoToCourse(courseDto, new Course());
        courseRepository.save(course);
    }
    public void update(int id, CourseDto courseDto){
        Course course = courseRepository.getById(id);
        course= modelToMapper.courseDtoToCourse(courseDto,course);
        courseRepository.save(course);
    }
    public CourseDto getById(int id){
        Course course = courseRepository.getById(id);
        return modelToMapper.courseToCourseDto(course,new CourseDto());
    }
    public void deleteById(int id){
        courseRepository.deleteById(id);
    }
}
