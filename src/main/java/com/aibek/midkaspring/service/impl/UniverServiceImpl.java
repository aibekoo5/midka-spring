package com.aibek.midkaspring.service.impl;

import com.aibek.midkaspring.dto.UniverDto;
import com.aibek.midkaspring.entity.UniverEntity;
import com.aibek.midkaspring.mapper.UniverMapper;
import com.aibek.midkaspring.repository.UniverRepo;
import com.aibek.midkaspring.service.UniverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniverServiceImpl implements UniverService {
    private final UniverRepo univerRepo;
    private final UniverMapper univerMapper;

    @Override
    public List<UniverDto> getAll() {
        return univerMapper.toDtoList(univerRepo.findAll());
    }

    @Override
    public UniverDto getById(Long id) {
        return univerMapper.toDto(univerRepo.findById(id).orElse(null));
    }

    @Override
    public void createUniver(UniverDto univerDto) {
        univerRepo.save(univerMapper.toEntity(univerDto));
    }

    @Override
    public void updateUniver(Long id, UniverDto univerDto) {
        UniverEntity updateUniverEntity = univerRepo.findById(id).orElse(null);

        if(univerDto != null){
            updateUniverEntity.setName(univerDto.getNameDto());
            updateUniverEntity.setDescription(univerDto.getDescriptionDto());
            updateUniverEntity.setCity(univerDto.getCity());
        }

        univerRepo.save(updateUniverEntity);
    }

    @Override
    public void deleteUniver(Long id) {
        univerRepo.deleteById(id);
    }
}
