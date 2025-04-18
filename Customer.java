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
            double thisAmount = amountFor(rental);

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

    private double amountFor(Rental each) {
        double thisAmount = 0;
        thisAmount = switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                double amount = 2;
                if (each.getDaysRented() > 2)
                    amount += (each.getDaysRented() - 2) * 1.5;
                yield amount;
            }
            case Movie.NEW_RELEASE -> each.getDaysRented() * 3;
            case Movie.CHILDRENS -> {
                double amount = 1.5;
                if (each.getDaysRented() > 3)
                    amount += (each.getDaysRented() - 3) * 1.5;
                yield amount;
            }
            default -> throw new IllegalArgumentException("Invalid price code: " + each.getMovie().getPriceCode());
        };
        return thisAmount;
    }

}