package com.Backend.Student_Library_Management_System.Models;

import com.Backend.Student_Library_Management_System.Enum.TransactionStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
    private String transactionId = UUID.randomUUID().toString();
    private Date transactionDate;
    private boolean isIssueOperation;

    @ManyToOne
    @JoinColumn
    private Book book;

    @ManyToOne
    @JoinColumn
    private Card card;


    public Transaction() {
    }

    public Transaction(TransactionStatus transactionStatus, Date transactionDate, boolean isIssueOperation) {
        this.transactionStatus = transactionStatus;
        this.transactionDate = transactionDate;
        this.isIssueOperation = isIssueOperation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIssueOperation() {
        return isIssueOperation;
    }

    public void setIssueOperation(boolean issueOperation) {
        isIssueOperation = issueOperation;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
