package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTOs.responseDTO.AuthorEmailResponseDto;
import com.example.LibraryManagementSystem.Entities.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    public String addAuthor(Author author);

    public AuthorEmailResponseDto getByEmail(String email);
}
