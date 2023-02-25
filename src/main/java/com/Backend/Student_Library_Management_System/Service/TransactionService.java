package com.Backend.Student_Library_Management_System.Service;

import com.Backend.Student_Library_Management_System.DTOs.IssueBookDto;
import com.Backend.Student_Library_Management_System.DTOs.ReturnBookDto;
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

        List<Book> booksIssued = card.getBooksIssued();
        booksIssued.add(book) ;
        card.setBooksIssued(booksIssued);

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

    public String returnBook(ReturnBookDto returnBookDto) {
        Book book = bookRepository.findById(returnBookDto.getBookId()).get();
        Card card= cardRepository.findById(returnBookDto.getCardId()).get();


        Transaction transaction = new Transaction(TransactionStatus.SUCCESS, new Date(), false);
        transaction.setCard(card);
        transaction.setBook(book);
        book.setIssued(false);

        List<Book> booksIssued = card.getBooksIssued();
        booksIssued.remove(book) ;
        card.setBooksIssued(booksIssued);

        List<Transaction> bookTransactionList = book.getListOfTransactions();
        bookTransactionList.add(transaction);
        book.setListOfTransactions(bookTransactionList);

        List<Transaction> cardTransactionList = card.getListOfTransactions();
        cardTransactionList.add(transaction);
        card.setListOfTransactions(cardTransactionList);

        cardRepository.save(card);
        return ("Book returned Successfully");

    }
}
