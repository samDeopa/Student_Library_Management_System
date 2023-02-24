package com.Backend.Student_Library_Management_System.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    //id parameter will auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;//auto generated
    private String name;
    @Column(unique = true)
    private  String email;

    private  String mobileNo;
    private  String country;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    Card card;


    public Student() {
    }

    public Student(int id, String name, String email, String mobileNo, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.country = country;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
