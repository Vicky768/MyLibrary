package com.library.sroy.LibraryProject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@SequenceGenerator(name="cardseq", initialValue = 100)
@Entity
public class LibraryCard {

    @Id
    @GeneratedValue(generator="cardseq")
    private Integer cardId;

    @OneToOne
    private Book issuedBook;

    private Date issueDate;
    private Date expecTedReturn;

    private boolean defaulter;

    public LibraryCard(){}

    public LibraryCard(Integer cardId, Book issuedBook, Date issueDate, Date expecTedReturn, boolean defaulter) {
        this.cardId = cardId;
        this.issuedBook = issuedBook;
        this.issueDate = issueDate;
        this.expecTedReturn = expecTedReturn;
        this.defaulter = defaulter;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Book getIssuedBookId() {
        return issuedBook;
    }

    public void setIssuedBookId(Book issuedBookId) {
        this.issuedBook = issuedBookId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpecTedReturn() {
        return expecTedReturn;
    }

    public void setExpecTedReturn(Date expecTedReturn) {
        this.expecTedReturn = expecTedReturn;
    }

    public boolean isDefaulter() {
        return defaulter;
    }

    public void setDefaulter(boolean defaulter) {
        this.defaulter = defaulter;
    }
}