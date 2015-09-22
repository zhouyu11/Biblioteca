package com.twu.biblioteca;


import org.junit.Test;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BibliotecaAppTest {

    @Test
    public void testWelcome(){
        assertEquals("Welcome to BibliotecaApp", BibliotecaApp.welcome());
    }

    @Test
    public void testGetBookList(){
        Book firstBook = new Book("book1", "yzhou", Year.of(2015));
        BookLibrary library = new BookLibrary(Arrays.asList(firstBook));

        List<Book> bookList =library.GetBooklist();
        assertNotNull(bookList);

        Book expectedBook = bookList.get(0);
        assertEquals(expectedBook.getAuthor(), firstBook.getAuthor());
        assertEquals(expectedBook.getBookName(), firstBook.getBookName());
        assertEquals(expectedBook.getYear(), firstBook.getYear());
    }

    @Test
    public void testGetMeau(){
        assertEquals("1:getBooklist", BibliotecaApp.getMeau()[0]);
        assertEquals("2:quit", BibliotecaApp.getMeau()[1]);
    }

    @Test
    public void testDoOptionGetBookList(){
        String message = BibliotecaApp.doOption(1);
        assertEquals("get booklist sucess !",message);
    }

    @Test
    public void testDoOptionQuit(){
        String message = BibliotecaApp.doOption(2);
        assertEquals("quit sucess!",message);
    }

    @Test
    public void should_return_invalid_option(){
        String message = BibliotecaApp.doOption(11);
        assertEquals("Select a valid option!",message);
    }

    @Test
    public void testCheckOutBook(){
        Book book = new Book("book1", "yzhou", Year.of(2015));
        BookLibrary library = new BookLibrary(Arrays.asList(book));
        String message = library.checkOut(0);
        assertEquals(false,book.getStatus());
        assertEquals("Thank you! Enjoy the book",message);
    }

    @Test
    public void should_not_get_book_checked(){
        Book unCheckoutBook = new Book("book1", "yzhou", Year.of(2015),true);
        Book checkedBook = new Book("book1", "yzhou", Year.of(2015),false);

        BookLibrary bookLibrary = new BookLibrary(Arrays.asList(unCheckoutBook, checkedBook));

        List<Book> bookList = bookLibrary.GetBooklist();
        assertEquals(1,bookList.size());
    }

    @Test
    public void should_return_error_message_when_checkout_samebook_twice(){
        BookLibrary library = new BookLibrary(Arrays.asList(new Book("book1", "yzhou", Year.of(2015))));
        library.checkOut(0);
        String message = library.checkOut(0);
        assertEquals("That book is not available.",message);
    }

    @Test
    public void testDoOptionCheckoutBook(){
        BibliotecaApp.IConsoleReader = new FakeConsoleReader("1");
        String message = BibliotecaApp.doOption(3);
        assertEquals("Thank you! Enjoy the book",message);
    }

    @Test
    public void testReturnBook(){
        Book book= new Book("book1", "yzhou", Year.of(2015),false);
        BookLibrary bookLibrary =new BookLibrary(Arrays.asList(book));
        String message = bookLibrary.returnBook("book1");

        assertEquals("Thank you for returning the book.",message);
        assertEquals(true,book.getStatus());
    }

    @Test
    public void should_return_error_message_when_return_invalid_book(){
        Book invalidBook= new Book("book1", "yzhou", Year.of(2015),true);
        BookLibrary bookLibrary =new BookLibrary(Arrays.asList(invalidBook));
        String message = bookLibrary.returnBook("book1");

        assertEquals("That is not a valid book to return.",message);
        assertEquals(true,invalidBook.getStatus());
    }

    @Test
    public void testDoOptionReturnBook(){
        BibliotecaApp.IConsoleReader = new FakeConsoleReader("book1");
        String message = BibliotecaApp.doOption(4);
        assertEquals("That is not a valid book to return.",message);
    }

}
