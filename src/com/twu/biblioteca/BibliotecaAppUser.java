package com.twu.biblioteca;

public class BibliotecaAppUser {
    private String PassWord;
    private String Name;
    private String EmailAddress;
    private String PhoneNumber;

    public BibliotecaAppUser(String name, String passWord, String emailAddress, String phoneNumber) {
        this.Name = name;
        this.PassWord = passWord;
        EmailAddress = emailAddress;
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}
