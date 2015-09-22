package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {


    public BookLibrary(List<Book> booksList){
        this.booksList = booksList;
    }

    public List<Book> GetBooklist() {
        List<Book> books = new ArrayList<Book>();
        for (Book book : this.booksList){
            if (book.getStatus()){
                books.add(book);
            }
        }
        return books;
    }

    private List<Book> booksList ;

    public String checkOut(int index) {
        Book book = this.booksList.get(index);
        if (book.getStatus()){
            this.booksList.get(index).setStatus(false);
            return "Thank you! Enjoy the book";
        }
        else {
            return "That book is not available.";
        }

    }

    public String returnBook(String bookName) {
        Book book = this.getBookByName(bookName);
        if (book.getStatus()) {
            return "That is not a valid book to return.";
        }
        book.setStatus(true);
        return "Thank you for returning the book.";
    }

    public Book getBookByName(String bookName) {
        Book book = new Book();
        for (Book bo : booksList){
            if (bo.getBookName().equals(bookName)){
                book = bo;
            }
        }
        return book;
    }
}
