package com.aibek.midkaspring.service.impl;

import com.aibek.midkaspring.dto.StudentDto;
import com.aibek.midkaspring.entity.StudentEntity;
import com.aibek.midkaspring.entity.UniverEntity;
import com.aibek.midkaspring.mapper.StudentMapper;
import com.aibek.midkaspring.repository.StudentRepo;
import com.aibek.midkaspring.repository.UniverRepo;
import com.aibek.midkaspring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl  implements StudentService{

    private final StudentMapper studentMapper;
    private final StudentRepo studentRepo;
    private final UniverRepo univerRepo;

    @Override
    public List<StudentDto> getAll() {
        return studentMapper.toDtoList(studentRepo.findAll());
    }

    @Override
    public StudentDto getById(Long id) {
        return studentMapper.toDto(studentRepo.findById(id).orElse(null));
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);

        UniverEntity university = univerRepo.findById(studentDto.getUniverId()).orElse(null);
        studentEntity.setUniver(university);

        studentRepo.save(studentEntity);
    }

    @Override
    public void updateStudent(Long id, StudentDto studentDto) {
        StudentEntity updateStudentEntity = studentRepo.findById(id).orElse(null);

        if(studentDto != null){
            updateStudentEntity.setFullname(studentDto.getFullnameDto());
            updateStudentEntity.setProfession(studentDto.getProfessionDto());
            updateStudentEntity.setAge(studentDto.getAge());

            UniverEntity university = univerRepo.findById(studentDto.getUniverId()).orElse(null);
            updateStudentEntity.setUniver(university);
        }

        studentRepo.save(updateStudentEntity);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
