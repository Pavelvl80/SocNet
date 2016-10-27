package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends AbstractParams {
    private long id;

    private String name;
    private int age;
    private Gender gender;
    private String password;
    private List<User> friends;
    private List<Message> messages;

    private String city;
    private Date dateRegistered;
    private Date dateLogin;

    private boolean isActive;

    //temlporary
    private boolean isLogged;

    public User(long id, String name, Gender gender, String password, String city) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.city = city;

        this.dateRegistered = this.dateLogin = new Date();
        this.isActive = true;
        this.friends = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", city='" + city + '\'' +
//                '}';
//    }


    public long getId() {
        return id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Date getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(Date dateLogin) {
        this.dateLogin = dateLogin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
