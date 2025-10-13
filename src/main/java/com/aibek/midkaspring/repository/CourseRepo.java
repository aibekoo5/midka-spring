package com.aibek.midkaspring.repository;

import com.aibek.midkaspring.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, Long> {
}
