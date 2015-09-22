package com.twu.biblioteca;

import java.util.Scanner;

public class ConsoleReader implements IConsoleReader {
    public String readDataFromConsole(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }
}
