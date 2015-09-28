package com.twu.biblioteca;

import java.io.IOException;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private static boolean status;
    private static BookLibrary bookLibrary =new BookLibrary(Arrays.asList(new Book("book1", "yzhou", Year.of(2015)), new Book("book2", "yu", Year.of(2014))));
    public static IConsoleReader IConsoleReader = new ConsoleReader();
    public static MovieLibrary movieLibrary = new MovieLibrary(Arrays.asList(new Movie("movieName1", Year.of(2015), "Ben", 8),new Movie("movieName2", Year.of(2014), "Ben", 0)));
    private static UserService userService =new UserService();
    private static CurrentUser currentUser;

    public static void main(String[] args) throws IOException {
        System.out.println(welcome());

        currentUser = getCurrentUser();
        status = userService.logIn(currentUser);
        if (!status){
            System.out.println("logIn failed !");
        }
        while (status){
            printMeau();
            int option = Integer.parseInt(IConsoleReader.readDataFromConsole("meau option:"));
            System.out.println(doOption(option));
        }
    }

    private static CurrentUser getCurrentUser() {
        String name = IConsoleReader.readDataFromConsole("user Name: ");
        String passWord = IConsoleReader.readDataFromConsole("input PassWord: ");
        return new CurrentUser(name,passWord);
    }

    private static void printMeau() {
        String[] meau = getMeau();
        System.out.println("meau : ");
        for (String m : meau){
            System.out.println(m);
        }
    }

    public static String[] getMeau() {
        return new String[]{
                "1:getBooklist"
                ,"2:quit",
                "3:check a book out",
                "4:return a book",
                "5:getMoviesList",
                "6:checkoutMovie",
                "7:getUserDetail"
        };


    }

    private static void printBookList(List<Book> booksList) {
        System.out.println("bookList: ");
        System.out.println("Name|" + "Author|" + "Year|");
        for (Book book :booksList){
            System.out.print(book.getBookName()+"|");
            System.out.print(book.getAuthor() + "|");
            System.out.print(book.getYear()+"|");
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
            case 3:optionMessage= doCheckoutBook();
                break;
            case 4:optionMessage=doReturnBook();
                break;
            case 5:optionMessage = doGetMoviesList();
                break;
            case 6:optionMessage = doCheckoutMovie();
                break;
            case 7:optionMessage = doGetUserInfor();
                break;
            default:
                optionMessage = doInvalidOption();
        }
        return optionMessage.equals("sucess")?"":optionMessage;
    }

    private static String doGetUserInfor() {
        printUserInfor(userService.getUserDetail(currentUser.getName()));
        return "sucess";
    }

    private static void printUserInfor(BibliotecaAppUser userDetail) {
        System.out.println("UserInfor: ");
        System.out.println("Name|" + "email|" + "phoneNumber|");
        System.out.print(userDetail.getName() + "|");
        System.out.print(userDetail.getEmailAddress() + "|");
        System.out.print(userDetail.getPhoneNumber() + "|");
        System.out.println();

    }

    private static String doCheckoutMovie() {
        String movieName = IConsoleReader.readDataFromConsole("input movie Name :");
        return movieLibrary.checkout(movieName);
    }

    public static String doGetMoviesList() {
        printMovieList(movieLibrary.getMoviesList());
        return "sucess";
    }

    private static void printMovieList(List<Movie> moviesList) {
        System.out.println("movieList: ");
        System.out.println("Name|" + "director|" + "Year|"+"Rate|");
        for (Movie movie :moviesList){
            System.out.print(movie.getName()+"|");
            System.out.print(movie.getDirector() + "|");
            System.out.print(movie.getYear()+"|");
            System.out.print(movie.getRete());
            System.out.println();
        }
    }

    private static String doReturnBook() {
        String bookName = IConsoleReader.readDataFromConsole("input book name you want to return :");
        return bookLibrary.returnBook(bookName);
    }

    private static String doCheckoutBook() {
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

    public static String doGetBookList() {
        printBookList(bookLibrary.GetBooklist());
        return "sucess";
    }

}
