package com.example.LibraryManagementSystem.DTOs.requestDTO;

import com.example.LibraryManagementSystem.Enums.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StudentRequestDto {

    private String name;

    private int age;

    private Department department;

    private String mobNo;

}
