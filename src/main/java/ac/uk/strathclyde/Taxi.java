package ac.uk.strathclyde;
import java.util.List;

/**
 * A taxi is able to carry a single passenger.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */

public class Taxi extends Vehicle implements Item
{
    private List<Passenger> passengers;
    private int capacity = 0;
    private int taxiId;

    /**
     * Constructor for objects of class Taxi
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public Taxi(TaxiCompany company, Location location, int id)
    {
        super(company, location);
        capacity = 5;
        this.taxiId = id;
    }

    /**
     * Carry out a taxi's actions.
     */
    public void act()
    {
        Location target = getTargetLocation();

        if(target != null) {
            if(passengers != null) {
                incrementWithPassengerCount();
            }
            // Find where to move to next.
            Location next = getLocation().nextLocation(target);
//            System.out.println("Taxi is at: " + getLocation());
//            System.out.println("Taxi is going to: " + target);
//            System.out.println("Distance: " + getLocation().distance(target));
            setLocation(next);
            incrementTravelCount();//total steps travelled
            if(next.equals(target)) {
                if(passengers != null) {
                    notifyPassengerArrival(passengers);
                    offloadPassenger();
                }
                else {
                    notifyPickupArrival();
                }
            }
        }
        else {
            incrementIdleCount();
        }
    }

    /**
     * Is the taxi free?
     * @return Whether or not this taxi is free.
     */
    public boolean isFree()
    {
        return getTargetLocation() == null && passengers == null;
    }

    /**
     * Receive a pickup location. This becomes the
     * target location.
     * @param location The pickup location.
     */
    public void setPickupLocation(Location location)
    {
        setTargetLocation(location);
    }

    /**
     * Receive a passenger.
     * Set their destination as the target location.
     * @param passengers The passengers.
     */
    public void pickup(List<Passenger> passengers)
    {
        if(passengers.size() > capacity) {
            throw new IllegalStateException("Not enough seats in the taxi!");
        }
        this.passengers = passengers;
        capacity -=passengers.size();
        setTargetLocation(passengers.get(0).getDestination());
    }

    /**
     * Offload the passengers.
     */
    public void offloadPassenger()
    {
        passengers = null;
        capacity = 5;
        clearTargetLocation();
    }

    /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    public String toString()
    {
        return "Taxi " + getTaxiId() + " at " + getLocation() + " with " + capacity + " available seats";
    }

    public void printStats() {
        System.out.println("Taxi No. " + getTaxiId() +
                " - total idle time: " + getIdleCount() +
                ", total travel time: " + getTotalTravelCount() +
                ", total with passenger time: " + getWithPassengerCount() +
                ", total travel to pick up time: " + calculateTravelToPickupCount(getTotalTravelCount(), getWithPassengerCount()));
    }

    public int getTaxiId() {
        return taxiId;
    }
}