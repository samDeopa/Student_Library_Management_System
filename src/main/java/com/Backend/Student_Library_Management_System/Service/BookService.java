package com.Backend.Student_Library_Management_System.Service;

import com.Backend.Student_Library_Management_System.DTOs.BookRequestDto;
import com.Backend.Student_Library_Management_System.Models.Author;
import com.Backend.Student_Library_Management_System.Models.Book;
import com.Backend.Student_Library_Management_System.Repository.AuthorRepository;
import com.Backend.Student_Library_Management_System.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public String addBook(BookRequestDto bookRequestDto) {

        int id = bookRequestDto.getAuthorId();

        Author author = authorRepository.findById(id).get();

        Book book = new Book(bookRequestDto.getName(), bookRequestDto.getPage(), bookRequestDto.getGenre());
        book.setIssued(false);
        book.setAuthor(author);

        List<Book> list = author.getBooksWritten();
        list.add(book);
        author.setBooksWritten(list);

        authorRepository.save(author);

        return  "Book added successfully";
    }

    public List<String> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        List<String> books = new ArrayList<>();
        for (Book book:bookList){
            books.add( book.getId() +" : "+ book.getName()  );
        }
        return books;
    }
}
