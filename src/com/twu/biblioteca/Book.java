package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private String yearPublished;

    public Book(String newTitle, String newAuthor, String newYearPublished) {
        title = newTitle;
        author = newAuthor;
        yearPublished = newYearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }
}
