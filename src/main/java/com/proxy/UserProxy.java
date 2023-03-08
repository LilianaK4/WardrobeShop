package com.proxy;


import com.user.IUser;
import com.user.User;

public class UserProxy implements IUser {
    private User user;

    @Override
    public String getName() {
        return this.user.getName();
    }


    @Override
    public String getSurname() {
        return this.user.getSurname();
    }

    @Override
    public String getLogin() {
        return this.user.getLogin();
    }

    @Override
    public int getPhone() {
        return this.user.getPhone();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }


    public IUser newUser(String name, String surname, String login, String password, int phone) {
        user = new User();
        return user.newUser(FirstCharToUpper(name), FirstCharToUpper(surname), login, password, phone);
    }

    private String FirstCharToUpper(String input) {
        return input.substring(0,1).toUpperCase() + input.toLowerCase().substring(1);
    }
}
