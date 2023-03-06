package com.Backend.Student_Library_Management_System.Controller;

import com.Backend.Student_Library_Management_System.DTOs.BookRequestDto;
import com.Backend.Student_Library_Management_System.Models.Book;
import com.Backend.Student_Library_Management_System.Repository.BookRepository;
import com.Backend.Student_Library_Management_System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public  String addBook(@RequestBody BookRequestDto bookRequestDto){

        return bookService.addBook(bookRequestDto);

    }
    @GetMapping("/getAllBooks")
    public ResponseEntity getAllBooks(){
        return  new ResponseEntity(bookService.getAllBooks(), HttpStatus.FOUND);
    }


}
