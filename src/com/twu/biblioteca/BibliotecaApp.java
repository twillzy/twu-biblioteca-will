package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        BibliotecaHelper bibliotecaHelper = new BibliotecaHelper();
        String welcomeMessage = biblioteca.sayWelcome();
        System.out.println(welcomeMessage);
        System.out.println("");

        User[] users = new User[2];
        users[0] = new User("Will Tan", "william.tanzy@gmail.com", "0430765887", "111-1111", "1111");
        users[1] = new User("Nicola Mele", "nmele@gmail.com", "0421718949", "222-2222", "2222");

        String libraryNo = "";
        String password;

        Book[] books = new Book[4];
        books[0] = new Book("Head First Java", "Kathy Sierra", "2003", true);
        books[1] = new Book("Eloquent Javascript", "Marijn Haverbeke", "2005", true);
        books[2] = new Book("Understanding Meteor", "Nicola Mele", "2014", true);
        books[3] = new Book("Functional Javascript", "Michael Fogus", "2013", false, "111-1111");

        Movie[] movies = new Movie[4];
        movies[0] = new Movie("Titanic", "1997", "James Cameron", "10", true);
        movies[1] = new Movie("Blue is the Warmest Colour", "2014", "Some french guy", "10", true);
        movies[2] = new Movie("My Own", "2016", "Twillzy", "1", true);
        movies[3] = new Movie("The Witch", "2019", "Twillzy", "unrated", false);

        boolean userHasLoggedIn = false;

        while(!userHasLoggedIn) {
            System.out.format("+---------------------------+%n");
            System.out.format("| Login%n");
            System.out.format("+---------------------------+%n");

            libraryNo = bibliotecaHelper.getUserInput("Enter your library number: ");
            password = bibliotecaHelper.getUserInput("Enter your password: ");

            userHasLoggedIn = biblioteca.userLogin(libraryNo, password, users);
        }

        System.out.format("+---------------------------+%n");
        System.out.format("| Menu%n");
        System.out.format("+---------------------------+%n");

        String[] menuOptions = {"List Books", "Borrow Book", "Return Book", "List Movies", "Borrow Movie", "View Account Details", "Quit"};

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
                    biblioteca.checkoutBook(checkoutBook, books, libraryNo);
                    System.out.println("");
                    selected = Integer.parseInt(bibliotecaHelper.getUserInput("Enter your selection: "));
                    break;
                case 3:
                    String returnBook = bibliotecaHelper.getUserInput("Enter the book title to return: ");
                    biblioteca.returnBook(returnBook, books, libraryNo);
                    System.out.println("");
                    selected = Integer.parseInt(bibliotecaHelper.getUserInput("Enter your selection: "));
                    break;
                case 4:
                    biblioteca.listAllMovies(movies);
                    System.out.println("");
                    selected = Integer.parseInt(bibliotecaHelper.getUserInput("Enter your selection: "));
                    break;
                case 5:
                    String checkoutMovie = bibliotecaHelper.getUserInput("Enter the movie title to borrow: ");
                    biblioteca.checkoutMovie(checkoutMovie, movies);
                    System.out.println("");
                    selected = Integer.parseInt(bibliotecaHelper.getUserInput("Enter your selection: "));
                    break;
                case 6:
                    biblioteca.listUserDetails(libraryNo, users);
                    System.out.println("");
                    selected = Integer.parseInt(bibliotecaHelper.getUserInput("Enter your selection: "));
                    break;
                case 7:
                    optionIsInvalid = false;
                    return;
                default:
                    selected = Integer.parseInt(bibliotecaHelper.getUserInput(("Select a valid option. Re-enter your selection: ")));
                    break;
            }
        }
    }
}
