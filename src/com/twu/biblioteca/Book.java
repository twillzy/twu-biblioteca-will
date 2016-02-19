package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private String yearPublished;
    private boolean isAvailable;

    public Book(String newTitle, String newAuthor, String newYearPublished, boolean newIsAvailable) {
        title = newTitle;
        author = newAuthor;
        yearPublished = newYearPublished;
        isAvailable = newIsAvailable;
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

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean newIsAvailable) {
        isAvailable = newIsAvailable;
    }
}
