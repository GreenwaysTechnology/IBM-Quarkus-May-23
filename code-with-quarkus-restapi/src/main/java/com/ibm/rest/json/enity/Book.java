package com.ibm.rest.json.enity;

public class Book {
    private String isbn;
    private String author;
    private String name;

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String isbn, String author, String name) {
        this.isbn = isbn;
        this.author = author;
        this.name = name;
    }
}
