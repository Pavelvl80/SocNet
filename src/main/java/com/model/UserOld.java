package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserOld extends BaseEntity {
    private Long id;

    private String name;
    private int age;
    private Gender gender;
    private String password;
    private List<UserOld> friends;
    private List<Messages> messages;

    private String city;
    private Date dateRegistered;
    private Date dateLogin;

    private boolean isActive;

    //temlporary
    private boolean isLogged;

    public UserOld(long id, String name, Gender gender, String password, String city) {
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
//        return "UserOld{" +
//                "name='" + name + '\'' +
//                ", city='" + city + '\'' +
//                '}';
//    }


    public Long getId() {
        return id;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
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

    public List<UserOld> getFriends() {
        return friends;
    }

    public void setFriends(List<UserOld> friends) {
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
