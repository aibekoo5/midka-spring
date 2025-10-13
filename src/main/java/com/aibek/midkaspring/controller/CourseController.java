package com.aibek.midkaspring.controller;

import com.aibek.midkaspring.dto.CourseDto;
import com.aibek.midkaspring.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(courseService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto){
        courseService.createCourse(courseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable(name = "id") Long id, @RequestBody CourseDto courseDto){
        courseService.updateCourse(id, courseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable(name = "id") Long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
