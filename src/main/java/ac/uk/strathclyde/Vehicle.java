package ac.uk.strathclyde;
import java.util.List;

/**
 * Model the common elements of taxis and shuttles.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public abstract class Vehicle implements Actor
{
    private TaxiCompany company;
    // Where the vehicle is.
    private Location location;
    // Where the vehicle is headed.
    private Location targetLocation;
    // Record how often the vehicle has nothing to do.
    private int idleCount;
    private int totalTravelCount;
    private int withPassengerCount;

    /**
     * Constructor of class Vehicle
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public Vehicle(TaxiCompany company, Location location)
    {
        if(company == null) {
            throw new NullPointerException("company");
        }
        if(location == null) {
            throw new NullPointerException("location");
        }
        this.company = company;
        this.location = location;
        targetLocation = null;
        idleCount = 0;
        totalTravelCount = 0;
        withPassengerCount = 0;
    }

    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
        company.arrivedAtPickup(this);
    }

    /**
     * Notify the company of our arrival at a
     * passenger's destination.
     */
    public void notifyPassengerArrival(List<Passenger> passengers)
    {
        company.arrivedAtDestination(this, passengers);
    }

    /**
     * Receive a pickup location.
     * How this is handled depends on the type of vehicle.
     * @param location The pickup location.
     */
    public abstract void setPickupLocation(Location location);

    /**
     * Receive a passenger.
     * How this is handled depends on the type of vehicle.
     * @param passengers The passenger.
     */
    public abstract void pickup(List<Passenger> passengers);

    /**
     * Is the vehicle free?
     * @return Whether or not this vehicle is free.
     */
    public abstract boolean isFree();

    /**
     * Offload any passengers whose destination is the
     * current location.
     */
    public abstract void offloadPassenger();

    /**
     * Get the location.
     * @return Where this vehicle is currently located.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Set the current location.
     * @param location Where it is. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setLocation(Location location)
    {
        if(location != null) {
            this.location = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Get the target location.
     * @return Where this vehicle is currently headed, or null
     *         if it is idle.
     */
    public Location getTargetLocation()
    {
        return targetLocation;
    }

    /**
     * Set the required target location.
     * @param location Where to go. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setTargetLocation(Location location)
    {
        if(location != null) {
            targetLocation = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Clear the target location.
     */
    public void clearTargetLocation()
    {
        targetLocation = null;
    }

    /**
     * @return On how many steps this vehicle has been idle.
     */
    public int getIdleCount()
    {
        return idleCount;
    }

    /**
     * Increment the number of steps on which this vehicle
     * has been idle.
     */
    public void incrementIdleCount()
    {
        idleCount++;
    }

    public void incrementTravelCount() { totalTravelCount++; }

    public void incrementWithPassengerCount() { withPassengerCount++; }

    public int calculateTravelToPickupCount(int total, int withPass) { return total - withPass; }

    public int getTotalTravelCount() { return totalTravelCount; }

    public int getWithPassengerCount() { return withPassengerCount; }
}

