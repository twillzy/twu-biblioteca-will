package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        String welcomeMessage = biblioteca.sayWelcome();
        System.out.println(welcomeMessage);
        System.out.println("");

        Book[] books = new Book[2];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003");
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005");


        String leftAlignFormat = "| %-25s | %-20s | %-4s %n";

        System.out.format("+---------------------------+----------------------+-----------------%n");
        System.out.format("| Title                     | Author               | Year Published  %n");
        System.out.format("+---------------------------+----------------------+-----------------%n");
        for (Book book: books) {
            System.out.format(leftAlignFormat, book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
    }
}
