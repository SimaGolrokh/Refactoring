package com.moviestore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testMovieTitle() {
        Movie movie = new RegularMovie("Inception");
        assertEquals("Inception", movie.getTitle());
    }

    @Test
    public void testRentalCharge() {
        Movie movie = new ChildrensMovie("Frozen");
        Rental rental = new Rental(movie, 4);
        double charge = rental.getCharge();
        assertEquals(3.0, charge, 0.01); // 1.5 + (4 - 3) * 1.5 = 3.0
    }

    @Test
    public void testCustomerStatement() {
        Movie movie1 = new NewReleaseMovie("The Matrix");
        Movie movie2 = new ChildrensMovie("Cars");
        Rental rental1 = new Rental(movie1, 3); // 3 * 3 = 9.0
        Rental rental2 = new Rental(movie2, 5); // 1.5 + (5 - 3) * 1.5 = 4.5
        Customer customer = new Customer("Alice");
        customer.addRental(rental1);
        customer.addRental(rental2);

        String statement = customer.statement();
        assertTrue(statement.contains("Rental Record for Alice"));
        assertTrue(statement.contains("The Matrix"));
        assertTrue(statement.contains("Cars"));
        assertTrue(statement.contains("Amount owed is 13.5"));
        assertTrue(statement.contains("You earned 3 frequent renter points")); // 2 + 1
    }

    @Test
    public void testProgramRuns() {
        // Just ensures that Program.main runs without crashing
        Program.main(new String[]{});
    }
}
