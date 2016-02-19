package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ExampleTest {

    @Test
    public void printWelcomeMessage() {
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.sayWelcome(), "Welcome to Biblioteca App");
    }

    @Test
    public void getBookTitle() {
        Book book = new Book("Head First Java", "Kathy Sierra", "2003", true);
        assertEquals(book.getTitle(), "Head First Java");
    }

    @Test
    public void getBookAuthor() {
        Book book = new Book("Head First Java", "Kathy Sierra", "2003", true);
        assertEquals(book.getAuthor(), "Kathy Sierra");
    }

    @Test
    public void getBookYearOfPublished() {
        Book book = new Book("Head First Java", "Kathy Sierra", "2003", true);
        assertEquals(book.getYearPublished(), "2003");
    }

    @Test
    public void checkoutExistingBook() {
        Book[] books = new Book[3];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", true);
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", true);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", true);
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.checkoutBook("Head First Java", books), "Success");
        assertFalse(books[0].getIsAvailable());
    }

    @Test
    public void checkoutNonExistingBook() {
        Book[] books = new Book[3];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", true);
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", true);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", true);
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.checkoutBook("Harry Potter", books), "Failure");
    }

    @Test
    public void returnExistingBook() {
        Book[] books = new Book[3];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", false);
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", false);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", true);
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.returnBook("Head First Java", books), "Success");
        assertTrue(books[0].getIsAvailable());
    }

    @Test
    public void returnNonExistingBook() {
        Book[] books = new Book[3];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", false);
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", false);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", true);
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.returnBook("Harry", books), "Failure");
    }

    @Test
    public void createNewMovie() {
        assertNotNull(new Movie("Titanic", "1997", "James Cameron", "10", true));
    }

    @Test
    public void getMovieDetails() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", "10", true);
        assertEquals(movie.getName(), "Titanic");
    }

    @Test
    public void setMovieAvailability() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", "10", true);
        movie.setIsAvailable(false);
        assertFalse(movie.getIsAvailable());
    }

    @Test
    public void checkoutExistingMovie() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", "10", true);
        Movie[] movies = new Movie[1];
        movies[0] = movie;
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.checkoutMovie("Titanic", movies), "Success");
        assertFalse("Failure- movie is not available", movie.getIsAvailable());
    }

    @Test
    public void checkoutNonExistingMovie() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", "10", true);
        Movie[] movies = new Movie[1];
        movies[0] = movie;
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.checkoutMovie("Harry Potter", movies), "Failure");
    }
}
