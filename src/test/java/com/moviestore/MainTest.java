package com.moviestore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testMovie() {
        Movie movie = new Movie("Inception", Movie.REGULAR);
        assertEquals("Inception", movie.getTitle());

        movie.setPriceCode(Movie.NEW_RELEASE);
        assertEquals(Movie.NEW_RELEASE, movie.getPriceCode());
    }

    @Test
    public void testRental() {
        Movie movie = new Movie("Frozen", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 4);
        double charge = rental.getCharge();
        assertTrue(charge > 0);
    }

    @Test
    public void testCustomerStatement() {
        Movie movie1 = new Movie("The Matrix", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("Cars", Movie.CHILDRENS);
        Rental rental1 = new Rental(movie1, 3);
        Rental rental2 = new Rental(movie2, 5);
        Customer customer = new Customer("Alice");
        customer.addRental(rental1);
        customer.addRental(rental2);

        String statement = customer.statement();
        assertTrue(statement.contains("Rental Record for Alice"));
        assertTrue(statement.contains("The Matrix"));
        assertTrue(statement.contains("Cars"));
    }

    @Test
    public void testProgramRuns() {
        // Just simulates that the Program runs without exceptions
        Program.main(new String[]{});
    }
}
