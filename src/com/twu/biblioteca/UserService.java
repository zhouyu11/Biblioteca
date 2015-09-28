package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class UserService {
    private final List<BibliotecaAppUser> BibliotecaAppUsers;

    public UserService(List<BibliotecaAppUser> bibliotecaAppUsers) {
        this.BibliotecaAppUsers = bibliotecaAppUsers;
    }

    public UserService() {

        BibliotecaAppUsers = Arrays.asList(new BibliotecaAppUser("yzhou","P@ss123", "qq@qq.com", "17066552351"));
    }

    public boolean logIn(CurrentUser currentUser) {
        boolean status =false;
        for (BibliotecaAppUser user:BibliotecaAppUsers){
            if (user.getName().equals(currentUser.getName())&&user.getPassWord().equals(currentUser.getPassWord())){
                status=true;
            }
        }
        return status;
    }

    public List<BibliotecaAppUser> getUsers() {
        return BibliotecaAppUsers;
    }

    public BibliotecaAppUser getUserDetail(String name) {
        BibliotecaAppUser user = null;
        for (BibliotecaAppUser bibliotecaAppUser:BibliotecaAppUsers){
            if (bibliotecaAppUser.getName().equals(name)){
                user=bibliotecaAppUser;
            }
        }
        return user ;
    }
}
