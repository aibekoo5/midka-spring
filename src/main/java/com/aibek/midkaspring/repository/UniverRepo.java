package com.aibek.midkaspring.repository;

import com.aibek.midkaspring.entity.UniverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniverRepo extends JpaRepository<UniverEntity, Long> {
}
