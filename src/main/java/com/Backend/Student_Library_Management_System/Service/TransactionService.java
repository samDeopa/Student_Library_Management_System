package com.Backend.Student_Library_Management_System.Service;

import com.Backend.Student_Library_Management_System.DTOs.IssueBookDto;
import com.Backend.Student_Library_Management_System.Enum.CardStatus;
import com.Backend.Student_Library_Management_System.Enum.TransactionStatus;
import com.Backend.Student_Library_Management_System.Models.Book;
import com.Backend.Student_Library_Management_System.Models.Card;
import com.Backend.Student_Library_Management_System.Models.Transaction;
import com.Backend.Student_Library_Management_System.Repository.BookRepository;
import com.Backend.Student_Library_Management_System.Repository.CardRepository;
import com.Backend.Student_Library_Management_System.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;
    public String issueBook(IssueBookDto issueBookDto) {
        Book book = bookRepository.findById(issueBookDto.getBookId()).get();
        Card card = cardRepository.findById(issueBookDto.getCardId()).get();
        if(book.isIssued()){
            return "Book Already Issued ";
        }

        if(!(card.getCardStatus() == CardStatus.ACTIVATED ) ){
            return "Card status : " +card.getCardStatus() ;
        }

        Transaction transaction = new Transaction( TransactionStatus.SUCCESS, new Date(), true);
        transaction.setBook(book);
        transaction.setCard(card);

        List<Transaction> bookTransactionList = book.getListOfTransactions();
        bookTransactionList.add(transaction);
        book.setListOfTransactions(bookTransactionList);

        List<Transaction> cardTransactionList = card.getListOfTransactions();
        cardTransactionList.add(transaction);
        card.setListOfTransactions(cardTransactionList);
        book.setIssued(true);

        cardRepository.save(card);

        return "Book issued Successfully";


    }
}
