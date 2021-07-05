package com.library.sroy.LibraryProject.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/*
* bookId
* bookName
* bookAuthor
* ShelfNumber
*
* */
@Entity
public class Book {

    @Id
    @NotNull
    private Integer bookId;

    private String bookName;
    private String bookAuthor;
    private String shelfNumber;

    private boolean issueStatus;


    public Book() {
    }

    public Book(Integer bookId, String bookName, String bookAuthor, String shelfNumber, boolean issueStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.shelfNumber = shelfNumber;
        this.issueStatus = issueStatus;

    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public boolean getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(boolean issueStatus) {
        this.issueStatus = issueStatus;
    }


}
