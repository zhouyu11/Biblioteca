package com.twu.biblioteca;

public class CurrentUser {
    private final String name;
    private final String passWord;

    public CurrentUser(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }
}
