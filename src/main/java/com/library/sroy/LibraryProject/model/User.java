package com.library.sroy.LibraryProject.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
* This is the user of the library
* containing
* userId
* Name
* Phone Number
* */

@Entity
public class User {

    @Id
    @NotNull
    @GeneratedValue
    private Integer userId;

    private String name;
    private String phnNo;

    public User() {
    }

    public User(Integer userId, String name, String phnNo) {
        this.userId = userId;
        this.name = name;
        this.phnNo = phnNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", phnNo='" + phnNo + '\'' +
                '}';
    }
}
