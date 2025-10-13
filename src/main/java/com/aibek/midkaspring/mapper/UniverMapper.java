package com.aibek.midkaspring.mapper;

import com.aibek.midkaspring.dto.UniverDto;
import com.aibek.midkaspring.entity.UniverEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UniverMapper {
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "descriptionDto", source = "description")
    UniverDto toDto(UniverEntity univerEntity);

    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "description", source = "descriptionDto")
    UniverEntity toEntity(UniverDto univerDto);

    List<UniverDto> toDtoList(List<UniverEntity> univerEntity);
}
