package com.moviestore;
class Rental {
    private final Movie movie;
    private final int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }
    public double getCharge() {
        return switch (movie.getPriceCode()) {
            case Movie.REGULAR -> {
                double amount = 2;
                if (daysRented > 2)
                    amount += (daysRented - 2) * 1.5;
                yield amount;
            }
            case Movie.NEW_RELEASE -> daysRented * 3;
            case Movie.CHILDRENS -> {
                double amount = 1.5;
                if (daysRented > 3)
                    amount += (daysRented - 3) * 1.5;
                yield amount;
            }
            default -> throw new IllegalArgumentException("Invalid price code: " + movie.getPriceCode());
        };
    }
    
}