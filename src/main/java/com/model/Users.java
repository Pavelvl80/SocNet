package com.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Edvard Piri on 09.11.2016.
 */

@Entity
@Table(name = "USERS")
public class Users extends BaseEntity {
    private Long id;
    private String email;
    private String userName;
    private String password;
    private String type;
    private String city;
    private String phone;
    private Date registered;
    private Date lastLogin;
    private Integer isLogin;
    private Integer isActive;

    private String attributes;

    public Users() {
    }

    public Users(String email, String password, String type, String userName) {
        this.email = email;
        this.password = password;
        this.type = type;
        this.userName = userName;

        this.isActive = 1;
        this.registered = new Date();
        this.lastLogin = new Date();
    }

    @Id
    @SequenceGenerator(name = "TEST_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SEQ")
    public Long getId() {
        return id;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }


    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }


    @Column(name = "TYPE")
    public String getType() {
        return type;
    }


    @Column(name = "CITY")
    public String getCity() {
        return city;
    }


    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }


    @Column(name = "DATE_REGISTERED")
    public Date getRegistered() {
        return registered;
    }


    @Column(name = "LAST_ACTIVE_DATE")
    public Date getLastLogin() {
        return lastLogin;
    }

    @Column(name = "IS_LOGIN")
    public Integer getIsLogin() {
        return isLogin;
    }

    @Column(name = "IS_ACTIVE")
    public Integer getIsActive() {
        return isActive;
    }


    @Column(name = "ATTRIBUTES")
    public String getAttributes() {
        return attributes;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "email='" + email + '\'' +
                ", userName='" + userName + '\'';
    }
}
