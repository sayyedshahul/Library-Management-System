package com.shahulsayyed.lms.library;

import com.shahulsayyed.lms.user.User;
import java.time.*;

class Book {
    private String isbn;
    private String title;
    private String author;
    private String status;
    private User issuedTo;
    private LocalDate issueDate;
    private LocalDate returnDate;

    Book(){}

    Book(String isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.status = "Available";
    }

     void setIsbn(String isbn){
        this.isbn = isbn;
    }

     void setTitle(String title){
        this.title = title;
    }

     void setAuthor(String author){
        this.author = author;
    }

     String getIsbn(){
        return isbn;
    }

     String getTitle(){
        return title;
    }

     String getAuthor(){
        return author;
    }

     String getStatus() {
        return status;
    }

     void setStatus(String status) {
        this.status = status;
    }

     User getIssuedTo() {
        return issuedTo;
    }

     void setIssuedTo(User issuedTo) {
        this.issuedTo = issuedTo;
    }

     LocalDate getIssueDate() {
        return issueDate;
    }

     void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

     LocalDate getReturnDate() {
        return returnDate;
    }

     void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
     public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", status='" + status + '\'' +
                ", issuedTo=" + issuedTo +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}

