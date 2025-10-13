package com.aibek.midkaspring.mapper;
import com.aibek.midkaspring.dto.StudentDto;
import com.aibek.midkaspring.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "professionDto", source = "profession")
    @Mapping(target = "fullnameDto", source = "fullname")
    @Mapping(target = "univerId", source = "univer.id")
    StudentDto toDto(StudentEntity studentEntity);

    @Mapping(target = "profession", source = "professionDto")
    @Mapping(target = "fullname", source = "fullnameDto")
    @Mapping(target = "univer", ignore = true)
    StudentEntity toEntity(StudentDto studentDto);

    List<StudentDto> toDtoList(List<StudentEntity> studentEntityList);
}
