package com.Backend.Student_Library_Management_System.Controller;

import com.Backend.Student_Library_Management_System.DTOs.IssueBookDto;
import com.Backend.Student_Library_Management_System.DTOs.ReturnBookDto;
import com.Backend.Student_Library_Management_System.Models.Transaction;
import com.Backend.Student_Library_Management_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public  String issueBook(@RequestBody IssueBookDto issueBookDto) throws Exception {
        return  transactionService.issueBook(issueBookDto);
    }

    @PostMapping("/returnBook")
    public  String returnBook(@RequestBody ReturnBookDto returnBookDto) throws Exception {
        return  transactionService.returnBook(returnBookDto);
    }
    @GetMapping("/getTransactions")
    public List<String> getTransactions(@RequestParam int cardId, @RequestParam int bookId){
        return  transactionService.getTransactions( bookId,cardId);
    }
}
