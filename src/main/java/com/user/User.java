package com.user;

public class User implements IUser {

    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private int phone;



    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() { return this.surname; }

    public String getLogin() {
        return this.login;
    }

    public int getPhone() {
        return this.phone;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User newUser(String name, String surname, String login, String password, int phone) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.phone = phone;
        return this;
    }
}
