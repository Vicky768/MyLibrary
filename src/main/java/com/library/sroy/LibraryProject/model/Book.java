package com.library.sroy.LibraryProject.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

/*
* bookId
* bookName
* bookAuthor
* ShelfNumber
*
* */
@SequenceGenerator(name = "bookSeq",initialValue = 6)
@Entity
public class Book {

    @Id
    @NotNull
    @GeneratedValue(generator = "bookSeq")
    private Integer bookId;

    private String bookName;
    private String bookAuthor;
    private String shelfNumber;

    private boolean issueStatus;



    public Book() {
    }

    /***
     *
     * @param bookId
     * @param bookName
     * @param bookAuthor
     * @param shelfNumber
     * @param issueStatus
     */

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
