package com.moviestore;

public abstract class Movie {
    private final String title;

    public Movie(String newTitle) {
        this.title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getCharge(int daysRented);
}
