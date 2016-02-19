package com.twu.biblioteca;

public class Movie {

    private String name;
    private String year;
    private String director;
    private String rating;
    private boolean isAvailable;

    public Movie(String newName, String newYear, String newDirector, String newRating, boolean newIsAvailable) {
        name = newName;
        year = newYear;
        director = newDirector;
        rating = newRating;
        isAvailable = newIsAvailable;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public String getDirector() {
        return director;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean newIsAvailable) {
        isAvailable = newIsAvailable;
    }
}
