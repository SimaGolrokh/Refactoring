package com.moviestore;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
