package com.twu.biblioteca;

import java.io.IOException;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private static boolean status;
    private static BookLibrary bookLibrary =new BookLibrary(Arrays.asList(new Book("book1", "yzhou", Year.of(2015)), new Book("book2", "yu", Year.of(2014))));;
    public static IConsoleReader IConsoleReader = new ConsoleReader();

    public static void main(String[] args) throws IOException {
        System.out.println(welcome());
        status = true;
        while (status){
            printMeau();
            int option = Integer.parseInt(IConsoleReader.readDataFromConsole("meau option:"));
            System.out.println(doOption(option));
        }
    }

    private static void printMeau() {
        String[] meau = getMeau();
        System.out.println("meau : ");
        for (String m : meau){
            System.out.println(m);
        }
    }

    public static String[] getMeau() {
        return new String[]{"1:getBooklist","2:quit","3:check a book out","4:return a book"};
    }

    private static void printBookList(List<Book> booksList) {
        System.out.println("bookList: ");
        System.out.println("Name|" + "Author|" + "Year|");
        for (Book book :booksList){
            System.out.print(book.getBookName()+"|");
            System.out.print(book.getAuthor() + "|");
            System.out.print(book.getYear()+"|");
            System.out.print(book.getStatus());
            System.out.println();
        }
    }

    public static String welcome(){
        return "Welcome to BibliotecaApp";
    }



    public static String doOption(int option) {
        String optionMessage = "";
        switch (option){
            case 1:
                optionMessage = doGetBookList();
                break;
            case 2:
                optionMessage = doQuit();
                break;
            case 3:optionMessage=doCheckout();
                break;
            case 4:optionMessage=doReturnBook();
                break;
            default:
                optionMessage = doInvalidOption();
        }
        return optionMessage;
    }

    private static String doReturnBook() {
        String bookName = IConsoleReader.readDataFromConsole("input book name you want to return :");
        return bookLibrary.returnBook(bookName);
    }

    private static String doCheckout() {
        Integer bookIndex = Integer.parseInt(IConsoleReader.readDataFromConsole("input index of book :"));
        return bookLibrary.checkOut(bookIndex);
    }

    private static String doInvalidOption() {
        return "Select a valid option!";
    }

    private static String doQuit() {
        status=false;
        return "quit sucess!";
    }

    private static String doGetBookList() {
        printBookList(bookLibrary.GetBooklist());
        return "get booklist sucess !";
    }

}
