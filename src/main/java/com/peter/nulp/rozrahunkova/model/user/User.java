package com.peter.nulp.rozrahunkova.model.user;

import com.peter.nulp.rozrahunkova.model.Model;
import com.peter.nulp.rozrahunkova.service.data.user.UserStatus;
import com.peter.nulp.rozrahunkova.service.utils.Utils;

public class User implements Model {

    private long id;

    private String name;
    private String surname;

    private String login;
    private String password;

    private int age = Utils.randomInt(30);
    private long balance = Utils.randomInt(100_000);

    private UserStatus status = UserStatus.USER;

    public User(){   /* для спрінга */

    }

    public User(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname, String login, String password, UserStatus status){
        this(name, surname);
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public User(String name, String surname, String login, String password){
        this(name, surname, login, password, UserStatus.USER);
    }


    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
