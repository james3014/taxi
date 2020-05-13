import java.util.*;

/**
 * Model the operation of a taxi company, operating different
 * types of vehicle. This version operates a single taxi.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TaxiCompany  
{
    // The vehicles operated by the company.
    private List<Vehicle> vehicles;
    // The associations between vehicles and the passengers
    // they are to pick up.
    private Map<Vehicle, List<Passenger>> assignments;
    private City city;
    private static final int NUMBER_OF_TAXIS = 3;

    /**
     * Constructor for objects of class TaxiCompany
     */
    public TaxiCompany(City city)
    {
        this.city = city;
        vehicles = new LinkedList<>();
        assignments = new HashMap<>();
        setupVehicles();
    }

    /**
     * Request a pickup for the given passengers.
     * @param passengers The passengers requesting a pickup.
     * @return Whether a free vehicle is available.
     */
    public boolean requestPickup(List<Passenger> passengers)
    {
        Vehicle vehicle = scheduleVehicle();
        if(vehicle != null) {
            assignments.put(vehicle, passengers);
            vehicle.setPickupLocation(passengers.get(0).getPickupLocation());
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * A vehicle has arrived at a pickup point.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtPickup(Vehicle vehicle)
    {
        List<Passenger> passengers = assignments.remove(vehicle);
        System.out.println(vehicle + " picks up " + listPassengers(passengers));
        for(Passenger p: passengers)
        {
            city.removeItem(p);
        }
        vehicle.pickup(passengers);
    }
    
    /**
     * A vehicle has arrived at a passenger's destination.
     * @param vehicle The vehicle at the destination.
     * @param passengers The passengers being dropped off.
     */
    public void arrivedAtDestination(Vehicle vehicle,
                                     List<Passenger> passengers)
    {
        System.out.println(vehicle + " offloads " + listPassengers(passengers));
    }
    
    /**
     * @return The list of vehicles.
     */
    public List<Vehicle> getVehicles()
    {
        return vehicles;
    }
    
    /**
     * Find a free vehicle, if any.
     * @return A free vehicle, or null if there is none.
     */
    private Vehicle scheduleVehicle()
    {
        Iterator<Vehicle> it = vehicles.iterator();
        while(it.hasNext()) {
            Vehicle vehicle = it.next();
            if(vehicle.isFree()) {
                return vehicle;
            }
        }
        return null;
    }

    /**
     * Display passenger details
     * @return passenger details
     */
    private String listPassengers(List<Passenger> passengers) {
        String message = passengers.get(0).getName();
        if (passengers.size() > 1) {
            for (int i = 1; i < passengers.size(); i++) {
                message += ", " + passengers.get(i).getName();
            }
        }
        return message += " travelling from " + passengers.get(0).getPickupLocation() +
                " to " + passengers.get(0).getDestination();
    }

    /**
     * Set up this company's vehicles. The optimum number of
     * vehicles should be determined by analysis of the
     * data gathered from the simulation.
     *
     * Vehicles start at random locations.
     */
    private void setupVehicles()
    {
        int cityWidth = city.getWidth();
        int cityHeight = city.getHeight();
        // Used a fixed random seed for predictable behavior.
        // Use different seeds for less predictable behavior.
        Random rand = new Random(12345);

        // Create the taxis.
        for(int i = 0; i < NUMBER_OF_TAXIS; i++){
            int taxiId = rand.nextInt(20) + 1;
            Taxi taxi =
                    new Taxi(this,
                            new Location(rand.nextInt(cityWidth),
                                    rand.nextInt(cityHeight)), taxiId);
            vehicles.add(taxi);
            city.addItem(taxi);
        }
    }
}
