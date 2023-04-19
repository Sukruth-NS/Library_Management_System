package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Entities.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    public String addBook(Book book) throws Exception;
}
