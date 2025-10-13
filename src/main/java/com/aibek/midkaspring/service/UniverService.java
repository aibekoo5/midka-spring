package com.aibek.midkaspring.service;
import com.aibek.midkaspring.dto.UniverDto;

import java.util.List;

public interface UniverService {
    List<UniverDto> getAll();
    UniverDto getById(Long id);
    void createUniver(UniverDto univerDto);
    void updateUniver(Long id, UniverDto univerDto);
    void deleteUniver(Long id);
}
