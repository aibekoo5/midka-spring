package com.aibek.midkaspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String profession;
    private int age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "univer_id")
    private UniverEntity univer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(table = "students"),
            inverseJoinColumns = @JoinColumn(table = "courses")
    )
    private List<CourseEntity> courseEntityList;
}
