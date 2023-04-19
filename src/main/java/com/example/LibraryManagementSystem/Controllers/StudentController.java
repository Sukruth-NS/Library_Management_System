package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.DTOs.requestDTO.StudentRequestDto;
import com.example.LibraryManagementSystem.DTOs.requestDTO.UpdateStudentMobRequestDto;
import com.example.LibraryManagementSystem.DTOs.responseDTO.StudentDetailResponseDto;
import com.example.LibraryManagementSystem.DTOs.responseDTO.UpdateStudentMobResponseDto;
import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Exceptions.StudentNotFoundException;
import com.example.LibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentServices;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentServices.addStudent(studentRequestDto);
    }

    @PutMapping("/update-mobNo")
    public UpdateStudentMobResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {
        return studentServices.updateMobNo(updateStudentMobRequestDto);
    }

    @GetMapping("/get_student")
    public StudentDetailResponseDto getStudent(@RequestParam("id")int id){
        return studentServices.getStudent(id);
    }
}
