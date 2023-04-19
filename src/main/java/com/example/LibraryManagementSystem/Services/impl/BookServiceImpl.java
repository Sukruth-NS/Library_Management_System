package com.example.LibraryManagementSystem.Services.impl;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.Services.AuthorService;
import com.example.LibraryManagementSystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addBook(Book book) throws Exception {

        Author author;
        try {
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Author doesn't exists");
        }

        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book Added Successfully";
    }
}
