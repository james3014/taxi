package ac.uk.strathclyde;

// Pickup location and Destination location cannot be the same

public class LocationClashException extends RuntimeException {
    private Passenger passenger;

    //Constructor for LocationClashException
    //Parameter passenger: The passenger being created

    public LocationClashException(Passenger passenger) {
        super("Location Clash! Pickup and Destination cannot be the same.");

    }

    //Return: The passenger which has clashing pickup and destination locations
    public Passenger getPassenger(){
        return passenger;
    }
}
