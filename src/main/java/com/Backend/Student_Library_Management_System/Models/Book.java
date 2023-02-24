package com.Backend.Student_Library_Management_System.Models;


import com.Backend.Student_Library_Management_System.Enum.Genre;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private  String name;
    private  int page;

    private  boolean issued;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    Card card;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> ListOfTransactions =  new  ArrayList<>();

    public Book() {
    }

    public Book( String name, int page, Genre genre) {
        this.name = name;
        this.page = page;
        this.genre = genre;
    }

    public List<Transaction> getListOfTransactions() {
        return ListOfTransactions;
    }

    public void setListOfTransactions(List<Transaction> listOfTransactions) {
        ListOfTransactions = listOfTransactions;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
