package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private String yearPublished;
    private boolean isAvailable;
    private String borrowedBy;

    public Book(String newTitle, String newAuthor, String newYearPublished, boolean newIsAvailable) {
        title = newTitle;
        author = newAuthor;
        yearPublished = newYearPublished;
        isAvailable = newIsAvailable;
    }

    public Book(String newTitle, String newAuthor, String newYearPublished, boolean newIsAvailable, String libraryNo) {
        title = newTitle;
        author = newAuthor;
        yearPublished = newYearPublished;
        isAvailable = newIsAvailable;
        borrowedBy = libraryNo;
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

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String newBorrowedBy) {
        borrowedBy = newBorrowedBy;
    }
}
