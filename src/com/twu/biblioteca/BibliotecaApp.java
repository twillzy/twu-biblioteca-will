package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        BibliotecaHelper bibliotecaHelper = new BibliotecaHelper();
        String welcomeMessage = biblioteca.sayWelcome();
        System.out.println(welcomeMessage);
        System.out.println("");

        Book[] books = new Book[4];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", true);
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", true);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", true);
        books[3] = new Book("Functional Javascript", "Michael Fogus", "2013", false);

        System.out.format("+---------------------------+%n");
        System.out.format("| Menu%n");
        System.out.format("+---------------------------+%n");

        String[] menuOptions = {"List Books", "Borrow Book", "Return Book", "Quit"};

        int index = 1;
        for (String menuOption: menuOptions) {
            System.out.format("| " + index + ". " + menuOption + "%n");
            index++;
        }

        System.out.println("");
        int selected = Integer.parseInt(bibliotecaHelper.getUserInput("Enter your selection: "));

        boolean optionIsInvalid = true;
        while(optionIsInvalid) {
            switch (selected) {
                case 1:
                    biblioteca.listAllBooks(books);
                    System.out.println("");
                    selected = Integer.parseInt(bibliotecaHelper.getUserInput("Enter your selection: "));
                    break;
                case 2:
                    String checkoutBook = bibliotecaHelper.getUserInput("Enter the book title to borrow: ");
                    biblioteca.checkoutBook(checkoutBook, books);
                    System.out.println("");
                    selected = Integer.parseInt(bibliotecaHelper.getUserInput("Enter your selection: "));
                    break;
                case 3:
                    String returnBook = bibliotecaHelper.getUserInput("Enter the book title to return: ");
                    biblioteca.returnBook(returnBook, books);
                    System.out.println("");
                    selected = Integer.parseInt(bibliotecaHelper.getUserInput("Enter your selection: "));
                    break;
                case 4:
                    optionIsInvalid = false;
                    return;
                default:
                    selected = Integer.parseInt(bibliotecaHelper.getUserInput(("Select a valid option. Re-enter your selection: ")));
                    break;
            }
        }
    }
}
