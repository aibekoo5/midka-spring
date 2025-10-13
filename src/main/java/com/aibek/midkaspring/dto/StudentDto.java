package com.aibek.midkaspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String fullnameDto;
    private String professionDto;
    private int age;
    private Long univerId;
}
