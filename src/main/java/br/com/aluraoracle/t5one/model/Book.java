package br.com.aluraoracle.t5one.model;

import jakarta.persistence.Entity;

@Entity
public class Book extends Product{
    private String author;
    private Long numberOfPages;

    public Book() {
    }

    public Book(String author, Long numberOfPages) {
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
