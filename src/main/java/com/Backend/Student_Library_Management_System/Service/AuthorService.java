package com.Backend.Student_Library_Management_System.Service;

import com.Backend.Student_Library_Management_System.Models.Author;
import com.Backend.Student_Library_Management_System.Models.Book;
import com.Backend.Student_Library_Management_System.Models.Card;
import com.Backend.Student_Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor(Author author) {
        authorRepository.save(author);
        return  "Author added successfully";
    }
}
