package com.library.sroy.LibraryProject.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

/*
* This is the user of the library
* containing
* userId
* Name
* Phone Number
* */
@SequenceGenerator(name="seq", initialValue = 5)
@Entity
public class User {

    @Id
    @NotNull
    @GeneratedValue(generator = "seq")
    private Integer userId;

    private String name;
    private String phnNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="card_id", referencedColumnName = "cardId")
    private LibraryCard card;

    public User() {
    }

    /**
     *
     *
     * @param userId
     * @param name
     * @param phnNo
     */
    public User(Integer userId, String name, String phnNo,LibraryCard card) {
        this.userId = userId;
        this.name = name;
        this.phnNo = phnNo;
        this.card = null;
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

    public LibraryCard getCard() {
        return card;
    }

    public void setCard(LibraryCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", phnNo='" + phnNo + '\'' +
                ", card=" + card +
                '}';
    }
}

