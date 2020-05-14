package ac.uk.strathclyde;
/**
 * Model a passenger wishing to get from one
 * location to another.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Passenger implements Item
{
    private Location pickup;
    private Location destination;
    private String name;

    /**
     * Constructor for objects of class Passenger
     * @param pickup The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @throws NullPointerException If either location is null.
     */
    public Passenger(Location pickup, Location destination, String name)
    {
        if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.pickup = pickup;
        this.destination = destination;
        this.name = name;
    }

    public String toString()
    {
        return "Passenger " + name + " travelling from " +
                pickup + " to " + destination;
    }

    /**
     * @return The passenger's pickup location.
     */
    public Location getLocation()
    {
        return pickup;
    }
    /**
     * @return The pickup location.
     */
    public Location getPickupLocation()
    {
        return pickup;
    }

    /**
     * @return The destination location.
     */
    public Location getDestination()
    {
        return destination;
    }

    public String getName() { return name; }
}
