package com.Backend.Student_Library_Management_System.Controller;

import com.Backend.Student_Library_Management_System.Models.Author;
import com.Backend.Student_Library_Management_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        return   authorService.addAuthor(author);
    }

    @GetMapping("/getAllAuthors")
    public ResponseEntity getAllAuthors(){
        return  new ResponseEntity(authorService.getAllAuthors(), HttpStatus.FOUND);
    }
}
