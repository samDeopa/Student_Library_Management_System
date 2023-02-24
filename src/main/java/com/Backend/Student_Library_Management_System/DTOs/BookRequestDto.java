package com.Backend.Student_Library_Management_System.DTOs;

import com.Backend.Student_Library_Management_System.Enum.Genre;

public class BookRequestDto {
    private String name;
    private  int page;
    private Genre genre;

    private  int authorId;

    public BookRequestDto() {
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
