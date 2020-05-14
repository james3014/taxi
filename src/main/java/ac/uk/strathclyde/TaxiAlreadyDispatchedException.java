package ac.uk.strathclyde;

// Taxi cannot be sent another pickup request if it already has a target location

public class TaxiAlreadyDispatchedException extends RuntimeException {

    private Vehicle vehicle;

    // Constructor for TaxiAlreadyDispatchedException
    // Parameter vehicle: The already dispatched vehicle which the new pickup request is being sent to.
    public TaxiAlreadyDispatchedException(Vehicle vehicle){
        super("This vehicle has already been dispatched and cannot accept another request at the moment.");
    }

    //Return: vehicle which has already been dispatched
    public Vehicle getVehicle(){
        return vehicle;
    }
}
