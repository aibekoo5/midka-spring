package com.aibek.midkaspring.controller;

import com.aibek.midkaspring.dto.StudentDto;
import com.aibek.midkaspring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto){
        studentService.createStudent(studentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable(name = "id") Long id, @RequestBody StudentDto studentDto){
        studentService.updateStudent(id, studentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}