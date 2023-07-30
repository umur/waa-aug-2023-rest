package com.example.Assignment2.service.Impl;

import com.example.Assignment2.dto.CourseDto;
import com.example.Assignment2.entity.Course;
import com.example.Assignment2.repositry.CourseRepo;
import com.example.Assignment2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl  implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public List<CourseDto> getAll() {

        List<Course> entityList=courseRepo.getAll();
        List<CourseDto>entityDtos=new ArrayList<>();
        entityList.forEach(entity->{
            var dto=new CourseDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setCode(entity.getCode());
            entityDtos.add(dto);

        });


        return entityDtos;
    }
    @Override
    public Optional<Course> getCourseById(int id) {
        Optional<Course> entityList=courseRepo.findById(id);
        return entityList;
    }
    @Override
    public void save(CourseDto course) {
        Course entity=new Course();
        entity.setId(course.getId());
        entity.setName(course.getName());
        entity.setCode(course.getCode());
        courseRepo.save(entity);

    }

    @Override
    public void update(Course course) {
      courseRepo.save(course);

    }


    @Override
    public void delete(int id){
        courseRepo.delete(id);
    }



}
