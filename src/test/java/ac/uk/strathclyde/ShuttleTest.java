package ac.uk.strathclyde;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShuttleTest {
    private TaxiCompany company;
    private Location location;

    /**
     * Default constructor for test class PassengerTest
     */
    public ShuttleTest() {
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     * <p>
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    /**
     *Test for no null values inside critical objects
     */
    @Test
    public void testShuttleCreation() {
        City city1 = new City();
        TaxiCompany company1 = new TaxiCompany(city1);
        Location startpoint1 = new Location(30, 20);
        Location destination = new Location(30, 20);
        Shuttle shuttle1 = new Shuttle(company1, startpoint1);
        shuttle1.setPickupLocation(destination);
        assertNotNull(destination);
        assertNotNull(startpoint1);
        assertNotNull(company1);
        assertNotNull(shuttle1);
    }
}

