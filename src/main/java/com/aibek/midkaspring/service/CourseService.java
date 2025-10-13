package com.aibek.midkaspring.service;

import com.aibek.midkaspring.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();
    CourseDto getById(Long id);
    void createCourse(CourseDto courseDto);
    void updateCourse(Long id, CourseDto courseDto);
    void deleteCourse(Long id);
}
