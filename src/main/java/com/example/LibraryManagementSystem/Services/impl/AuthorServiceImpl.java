package com.example.LibraryManagementSystem.Services.impl;

import com.example.LibraryManagementSystem.DTOs.responseDTO.AuthorEmailResponseDto;
import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(Author author) {


        authorRepository.save(author);
        return "Author Added Successfully";
    }

    @Override
    public AuthorEmailResponseDto getByEmail(String email) {
        Author author = authorRepository.findByEmail(email);

        //creating response
        AuthorEmailResponseDto authorEmailResponseDto = new AuthorEmailResponseDto();
        authorEmailResponseDto.setName(author.getName());
        authorEmailResponseDto.setAge(author.getAge());

        return authorEmailResponseDto;
    }
}
