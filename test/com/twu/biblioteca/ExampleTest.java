package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void printWelcomeMessage() {
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.sayWelcome(), "Welcome to Biblioteca App");
    }

    @Test
    public void getBookTitle() {
        Book book = new Book("Head First Java", "Kathy Sierra", "2003");
        assertEquals(book.getTitle(), "Head First Java");
    }

    @Test
    public void getBookAuthor() {
        Book book = new Book("Head First Java", "Kathy Sierra", "2003");
        assertEquals(book.getAuthor(), "Kathy Sierra");
    }

    @Test
    public void getBookYearOfPublished() {
        Book book = new Book("Head First Java", "Kathy Sierra", "2003");
        assertEquals(book.getYearPublished(), "2003");
    }
}
