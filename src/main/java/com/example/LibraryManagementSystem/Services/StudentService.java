package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTOs.requestDTO.StudentRequestDto;
import com.example.LibraryManagementSystem.DTOs.requestDTO.UpdateStudentMobRequestDto;
import com.example.LibraryManagementSystem.DTOs.responseDTO.StudentDetailResponseDto;
import com.example.LibraryManagementSystem.DTOs.responseDTO.UpdateStudentMobResponseDto;
import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Exceptions.StudentNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    public String addStudent(StudentRequestDto studentRequestDto) ;

    public UpdateStudentMobResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException;

    public StudentDetailResponseDto getStudent(int id);
}
