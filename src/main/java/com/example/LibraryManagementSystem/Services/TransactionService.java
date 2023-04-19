package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTOs.requestDTO.IssueBookRequestDto;
import com.example.LibraryManagementSystem.DTOs.responseDTO.IssueBookResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
