package com.Backend.Student_Library_Management_System.Models;

import com.Backend.Student_Library_Management_System.Enum.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//auto generated

    //it will auto time stamp when the entity is created
    @CreationTimestamp
    private Date createdOn;//auto generated

    //it will mark the time stamp when the entity id updated
    @UpdateTimestamp
    private Date updateOn;//auto generated

    @Enumerated(value =  EnumType.STRING)
    private CardStatus cardStatus;

    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> booksIssued= new ArrayList<>();;

    @OneToMany(mappedBy = "card", cascade =  CascadeType.ALL)
    List<Transaction> listOfTransactions =  new  ArrayList<>();

    public Card() {

    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

    public List<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transaction> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

}
