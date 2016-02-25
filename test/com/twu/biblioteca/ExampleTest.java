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
        assertEquals(biblioteca.checkoutBook("Head First Java", books, "111-1111"), "Success");
        assertFalse(books[0].getIsAvailable());
    }

    @Test
    public void checkoutNonExistingBook() {
        Book[] books = new Book[3];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", true);
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", true);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", true);
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.checkoutBook("Harry Potter", books, "111-1111"), "Failure");
    }

    @Test
    public void returnExistingBook() {
        Book[] books = new Book[3];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", false, "111-1111");
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", false);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", true);
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.returnBook("Head First Java", books, "111-1111"), "Success");
        assertTrue(books[0].getIsAvailable());
    }

    @Test
    public void returnNonExistingBook() {
        Book[] books = new Book[3];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", false);
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", false);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", true);
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.returnBook("Harry", books, "111-1111"), "Failure");
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

    @Test
    public void createNewUser() {
        User user = new User("Will Tan", "william.tanzy@gmail.com", "0430765887", "111-1111", "1111");
        assertNotNull(user);
    }

    @Test
    public void userLogin() {
        User user1 = new User("Will Tan", "william.tanzy@gmail.com", "0430765887", "111-1111", "1111");
        User user2 = new User("Nicola Mele", "nmele@gmail.com", "0421718949", "222-2222", "2222");
        User[] users = new User[2];
        users[0] = user1;
        users[1] = user2;
        String userEnteredLibraryNo = "111-1111";
        String userEnteredPassword = "1111";
        Biblioteca biblioteca = new Biblioteca();
        boolean loginSuccess = biblioteca.userLogin(userEnteredLibraryNo, userEnteredPassword, users);
        assertTrue(loginSuccess);
    }

    @Test
    public void checkoutBookWillShowBorrowedBy() {
        Book[] books = new Book[3];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", true);
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", true);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", true);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.checkoutBook("Head First Java", books, "111-1111");
        assertEquals(books[0].getBorrowedBy(), "111-1111");
    }

    @Test
    public void onlyReturnWhatYouBorrow() {
        Book[] books = new Book[3];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", true);
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", true);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", false, "111-1111");
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.returnBook("Understanding Meteor", books, "111-1111"), "Success");
        assertTrue(books[2].getIsAvailable());
    }
}
