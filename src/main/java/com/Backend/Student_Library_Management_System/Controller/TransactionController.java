package com.Backend.Student_Library_Management_System.Controller;

import com.Backend.Student_Library_Management_System.DTOs.IssueBookDto;
import com.Backend.Student_Library_Management_System.Models.Transaction;
import com.Backend.Student_Library_Management_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public  String issueBook(@RequestBody IssueBookDto issueBookDto){
        return  transactionService.issueBook(issueBookDto);
    }
}
