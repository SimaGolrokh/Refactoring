import java.util.ArrayList;
import java.util.List;


class Customer {
    private final String name;
    //Change Vector to ArrayList
    private final List <Rental> rentals = new ArrayList<>();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental rental) {
        rentals.add(rental);
    };
    public String getName(){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + getName() + "\n";
        result += """
            \tTitle\t\tDays\tAmount
            """;

        for (Rental rental : rentals) {
            double thisAmount = rental.getCharge();

            frequentRenterPoints++;

            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }


}