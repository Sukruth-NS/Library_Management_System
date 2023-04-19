package com.example.LibraryManagementSystem.DTOs.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UpdateStudentMobRequestDto {
    private int id;
    private String mobNo;
}
