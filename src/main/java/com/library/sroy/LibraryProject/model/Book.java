package com.library.sroy.LibraryProject.model;

import com.sun.istack.NotNull;

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
    private Date issueDate;
    private Date expectedReturn;
    private Double generatedFine;

    public Book() {
    }

    public Book(Integer bookId, String bookName, String bookAuthor, String shelfNumber, boolean issueStatus, Date issueDate, Date expectedReturn, Double generatedFine) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.shelfNumber = shelfNumber;
        this.issueStatus = issueStatus;
        this.issueDate = issueDate;
        this.expectedReturn = expectedReturn;
        this.generatedFine = generatedFine;
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

    public boolean isIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(boolean issueStatus) {
        this.issueStatus = issueStatus;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpectedReturn() {
        return expectedReturn;
    }

    public void setExpectedReturn(Date expectedReturn) {
        this.expectedReturn = expectedReturn;
    }

    public Double getGeneratedFine() {
        return generatedFine;
    }

    public void setGeneratedFine(Double generatedFine) {
        this.generatedFine = generatedFine;
    }
}
