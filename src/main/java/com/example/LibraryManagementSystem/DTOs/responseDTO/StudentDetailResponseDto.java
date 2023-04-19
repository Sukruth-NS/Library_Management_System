package com.example.LibraryManagementSystem.DTOs.responseDTO;

import com.example.LibraryManagementSystem.Entities.Card;
import com.example.LibraryManagementSystem.Enums.Department;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StudentDetailResponseDto {
    private int id;

    private String name;

    private int age;

    private Department department;

    private String mobNo;

    CardResponseDto cardResponseDto;
}
