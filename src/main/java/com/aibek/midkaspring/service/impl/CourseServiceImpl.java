package com.aibek.midkaspring.service.impl;

import com.aibek.midkaspring.dto.CourseDto;
import com.aibek.midkaspring.entity.CourseEntity;
import com.aibek.midkaspring.mapper.CourseMapper;
import com.aibek.midkaspring.repository.CourseRepo;
import com.aibek.midkaspring.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;
    private final CourseRepo courseRepo;

    @Override
    public List<CourseDto> getAll() {
        return courseMapper.toDtoList(courseRepo.findAll());
    }

    @Override
    public CourseDto getById(Long id) {
        return courseMapper.toDto(courseRepo.findById(id).orElse(null));
    }

    @Override
    public void createCourse(CourseDto courseDto) {
        courseRepo.save(courseMapper.toEntity(courseDto));
    }

    @Override
    public void updateCourse(Long id, CourseDto courseDto) {
        CourseEntity updateCourseEntity = courseRepo.findById(id).orElse(null);

        if(courseDto != null){
            updateCourseEntity.setName(courseDto.getNameDto());
            updateCourseEntity.setDescription(courseDto.getDescriptionDto());
            updateCourseEntity.setLesson(courseDto.getLesson());
        }

        courseRepo.save(updateCourseEntity);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
