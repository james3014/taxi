package ac.uk.strathclyde;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * The test class CityTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class CityTest {

    private City city;
    private List<Item> items;
    private int width;
    private int height;
    /**
     * Default constructor for test class PassengerTest
     */
    public CityTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testCity(){
        City city = new City(10,20);
        assertEquals(10, city.getWidth());
        assertEquals(20, city.getHeight());
    }
}
