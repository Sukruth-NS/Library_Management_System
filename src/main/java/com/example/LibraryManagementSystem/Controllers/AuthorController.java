package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.DTOs.responseDTO.AuthorEmailResponseDto;
import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @PutMapping("/get-by-email")
    public AuthorEmailResponseDto getByEmail(@RequestParam("email") String email){
        return authorService.getByEmail(email);
    }
}
