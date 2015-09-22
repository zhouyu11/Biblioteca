package com.twu.biblioteca;

import java.time.Year;

public class Book {
    private String BookName;
    private String Author;
    private Year Year;
    private boolean Status;

    public Book(String bookName, String author, Year year) {
        this.BookName = bookName;
        this.Author = author;
        this.Year = year;
        this.Status = true;
    }


    public Book(String bookName, String author, Year year,boolean status) {
        this.BookName = bookName;
        this.Author = author;
        this.Year = year;
        this.Status = status;
    }

    public Book() {

    }

    public String getBookName() {
        return this.BookName;
    }

    public String getAuthor() {
        return this.Author;
    }

    public Year getYear() {
        return this.Year;
    }

    public boolean getStatus() {
        return this.Status;
    }

    public void setStatus(boolean status) {
        this.Status = status;
    }
}
