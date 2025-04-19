package com.moviestore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    public void testGetTitle() {
        Movie movie = new Movie("Inception", Movie.REGULAR);
        assertEquals("Inception", movie.getTitle());
    }

    @Test
    public void testSetAndGetPriceCode() {
        Movie movie = new Movie("Avatar", Movie.CHILDRENS);
        movie.setPriceCode(Movie.NEW_RELEASE);
        assertEquals(Movie.NEW_RELEASE, movie.getPriceCode());
    }
}
