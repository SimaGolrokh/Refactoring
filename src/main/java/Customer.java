import java.util.ArrayList;
import java.util.List;


class Customer {
    private final String name;
    //Change Vector to ArrayList
    private final List <Rental> rentals = new ArrayList<>();
    public Customer (String newname){
        name = newname;
    }
    public void addRental(Rental rental) {
        rentals.add(rental);
    }
    public String getName(){
        return name;
    }
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ").append(getName()).append("\n");
        result.append("\tTitle\t\tDays\tAmount\n");

        for (Rental rental : rentals) {
            double thisAmount = rental.getCharge();

            frequentRenterPoints++;

            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            result.append(String.format("%-20s\t%3d\t%.1f\n",
                rental.getMovie().getTitle(),
                rental.getDaysRented(),
                rental.getCharge()));
                totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();

    }


}