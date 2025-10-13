package com.aibek.midkaspring.service;
import com.aibek.midkaspring.dto.StudentDto;
import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();
    StudentDto getById(Long id);
    void createStudent(StudentDto studentDto);
    void updateStudent(Long id, StudentDto studentDto);
    void deleteStudent(Long id);
}
