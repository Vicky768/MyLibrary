package com.library.sroy.LibraryProject.model;

import javax.persistence.*;
import java.time.LocalDate;

@SequenceGenerator(name="cardseq", initialValue = 100)
@Entity
public class LibraryCard {

    @Id
    @GeneratedValue(generator="cardseq")
    private Integer cardId;

    @OneToOne
    private Book issuedBook;

    private LocalDate issueDate;
    private LocalDate expectedReturn;

    private boolean defaulter;

    public LibraryCard(){}

    public LibraryCard(Integer cardId, Book issuedBook, LocalDate issueDate, LocalDate expecTedReturn, boolean defaulter) {
        this.cardId = cardId;
        this.issuedBook = issuedBook;
        this.issueDate = issueDate;
        this.expectedReturn = expecTedReturn;
        this.defaulter = defaulter;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Book getIssuedBook() {
        return issuedBook;
    }

    public void setIssuedBook(Book issuedBook) {
        this.issuedBook = issuedBook;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpecTedReturn() {
        return expectedReturn;
    }

    public void setExpecTedReturn(LocalDate expecTedReturn) {
        this.expectedReturn = expecTedReturn;
    }

    public boolean isDefaulter() {
        return defaulter;
    }

    public void setDefaulter(boolean defaulter) {
        this.defaulter = defaulter;
    }

    public boolean hasBookIssued(){
        if(this.issuedBook!=null)
            return true;
        return false;
    }
}