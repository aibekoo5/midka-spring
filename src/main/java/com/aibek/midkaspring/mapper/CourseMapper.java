package com.aibek.midkaspring.mapper;
import com.aibek.midkaspring.dto.CourseDto;
import com.aibek.midkaspring.entity.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "descriptionDto", source = "description")
    CourseDto toDto(CourseEntity courseEntity);

    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "description", source = "descriptionDto")
    CourseEntity toEntity(CourseDto courseDto);

    List<CourseDto> toDtoList(List<CourseEntity> courseEntity);
}
