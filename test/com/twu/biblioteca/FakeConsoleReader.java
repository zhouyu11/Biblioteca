package com.twu.biblioteca;

public class FakeConsoleReader implements IConsoleReader {

    private String input;
    public FakeConsoleReader(String input){
        this.input=input;
    }

    public String readDataFromConsole(String message) {
        return this.input;
    }
}
