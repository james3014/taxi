package ac.uk.strathclyde;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PassengerSourceTest.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class PassengerSourceTest
{
    private PassengerSource source;
    private TaxiCompany company1;
    private Passenger passenger;


    /**
     * Default constructor for test class PassengerSourceTest
     */
    public PassengerSourceTest()
    {
    }


    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }


    /**
     *Test for successful pickup of a passenger.
     */
    @Test
    public void testPickup()
    {
        Location pickup = new Location(10,20);
        Location destination = new Location(50, 70);
        Passenger passenger1 = new Passenger(pickup, destination, "passenger1");
        List<Passenger> passengerslist = new ArrayList<Passenger>();
        passengerslist.add(passenger1);
        City city1 = new City();
        TaxiCompany company1 = new TaxiCompany(city1);
        source = new PassengerSource(city1, company1);
        Location taxiLocation = new Location(0, 0);
        Taxi taxi = new Taxi(company1, taxiLocation, 1);
        List<Vehicle> vehicles = company1.getVehicles();
        vehicles.add(taxi);

        assertEquals(true, company1.requestPickup(passengerslist));

        if(pickup==null){
            throw new IllegalArgumentException("No pickup location specified");
        }
        if(destination==null){
            throw new IllegalArgumentException("No destination specified");
        }
    }
}
