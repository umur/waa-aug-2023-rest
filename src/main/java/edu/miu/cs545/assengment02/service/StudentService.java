package edu.miu.cs545.assengment02.service;

import edu.miu.cs545.assengment02.dto.CourseDto;
import edu.miu.cs545.assengment02.dto.CoursesStudentDto;
import edu.miu.cs545.assengment02.dto.StudentDto;
import edu.miu.cs545.assengment02.entity.Student;
import edu.miu.cs545.assengment02.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final ModelMapper mapper;
    private final StudentRepo repo;

    public List<StudentDto> getAll() {
        var entity = repo.getAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        entity.forEach(student -> {
            StudentDto studentDto = mapper.map(student, StudentDto.class);
            studentDtoList.add(studentDto);
        });
        return studentDtoList;

    }

    public List<StudentDto> getByMajor(String major) {
        var entity = repo.getAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        entity.stream().filter(s -> s.getMajor().equalsIgnoreCase(major))
                .forEach(student -> {
                    StudentDto dto = mapper.map(student, StudentDto.class);
                    studentDtoList.add(dto);
                });
        return  studentDtoList;
    }

    public List<CourseDto> getCoursesByStudentId(int id) {
        var entity = repo.getById(id);

        System.out.println("Courses " + entity);

        List<CourseDto> courseDtoList = new ArrayList<>();
        entity.getCoursesTaken().forEach(course -> {
            CourseDto buildCourseDto = CourseDto.builder().name(course.getName())
                    .code(course.getCode())
                    .id(course.getId()).build();
            courseDtoList.add(buildCourseDto);});
        return courseDtoList;
    }
}
