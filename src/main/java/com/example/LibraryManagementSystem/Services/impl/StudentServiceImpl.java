package com.example.LibraryManagementSystem.Services.impl;

import com.example.LibraryManagementSystem.DTOs.requestDTO.StudentRequestDto;
import com.example.LibraryManagementSystem.DTOs.requestDTO.UpdateStudentMobRequestDto;
import com.example.LibraryManagementSystem.DTOs.responseDTO.CardResponseDto;
import com.example.LibraryManagementSystem.DTOs.responseDTO.StudentDetailResponseDto;
import com.example.LibraryManagementSystem.DTOs.responseDTO.UpdateStudentMobResponseDto;
import com.example.LibraryManagementSystem.Entities.Card;
import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Exceptions.StudentNotFoundException;
import com.example.LibraryManagementSystem.Repositories.StudentRepository;
import com.example.LibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        //adding same
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        //generated new card for a student
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setValidTill("2040-01-09");
        card.setStudent(student);

        //set card for the student
        student.setCard(card);

        studentRepository.save(student);
        return "Student Added Successfully";
    }

    @Override
    public UpdateStudentMobResponseDto updateMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        try {
            Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();
            student.setMobNo(updateStudentMobRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            //prepare response dto
            UpdateStudentMobResponseDto ans = new UpdateStudentMobResponseDto();
            ans.setName(updatedStudent.getName());
            ans.setName(updatedStudent.getMobNo());

            return ans;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid Student Id");
        }

    }

    @Override
    public StudentDetailResponseDto getStudent(int id) {
        Student student = studentRepository.findById(id).get();

        StudentDetailResponseDto studentDetailResponseDto = new StudentDetailResponseDto();

        studentDetailResponseDto.setId(student.getId());
        studentDetailResponseDto.setName(student.getName());
        studentDetailResponseDto.setAge(student.getAge());
        studentDetailResponseDto.setDepartment(student.getDepartment());
        studentDetailResponseDto.setMobNo(student.getMobNo());

        CardResponseDto cardResponseDto = new CardResponseDto();

        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setUpdateDate(student.getCard().getUpdateTime());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setValidTill(student.getCard().getValidTill());

        studentDetailResponseDto.setCardResponseDto(cardResponseDto);
        return studentDetailResponseDto;
    }
}
