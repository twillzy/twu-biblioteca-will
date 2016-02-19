package com.twu.biblioteca;

public class Biblioteca {

    public String sayWelcome() {
        return "Welcome to Biblioteca App";
    }

    public void listAllBooks(Book[] books) {
        String leftAlignFormat = "| %-25s | %-20s | %-4s %n";

        System.out.format("+---------------------------+----------------------+-----------------%n");
        System.out.format("| Title                     | Author               | Year Published  %n");
        System.out.format("+---------------------------+----------------------+-----------------%n");
        for (Book book: books) {
            if (book.getIsAvailable()) {
                System.out.format(leftAlignFormat, book.getTitle(), book.getAuthor(), book.getYearPublished());
            }
        }
    }

    public void listAllMovies(Movie[] movies) {
        String leftAlignFormat = "| %-30s | %-4s | %-20s | %-10s %n";

        System.out.format("+--------------------------------+------+----------------------+--------%n");
        System.out.format("| Title                          | Year | Director             | Rating %n");
        System.out.format("+--------------------------------+------+----------------------+--------%n");
        for (Movie movie: movies) {
            if (movie.getIsAvailable()) {
                System.out.format(leftAlignFormat, movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating());
            }
        }
    }

    public String checkoutBook(String title, Book[] books) {
        for (Book book: books) {
            if (book.getTitle().equals(title) && book.getIsAvailable()) {
                book.setIsAvailable(false);
                System.out.println("Thank you! Enjoy the book");
                return "Success";
            }
        }
        System.out.println("That book is not available");
        return "Failure";
    }

    public String returnBook(String title, Book[] books) {
        for (Book book: books) {
            if (book.getTitle().equals(title) && !book.getIsAvailable()) {
                book.setIsAvailable(true);
                System.out.println("Thank you for returning the book");
                return "Success";
            }
        }
        System.out.println("That is not a valid book to return.");
        return "Failure";
    }

    public String checkoutMovie(String name, Movie[] movies) {
        for (Movie movie: movies) {
            if (movie.getName().equals(name) && movie.getIsAvailable()) {
                movie.setIsAvailable(false);
                System.out.println("Thank you! Enjoy the movie");
                return "Success";
            }
        }
        System.out.println("That movie is not available");
        return "Failure";
    }
}
