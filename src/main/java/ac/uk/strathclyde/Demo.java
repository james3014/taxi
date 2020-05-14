package ac.uk.strathclyde;

import java.util.List;
import java.util.LinkedList;

/**
 * Provide a simple demonstration of running a stage-one
 * scenario. A single passenger is created, and a pickup
 * requested. As the simulation is run, the passenger
 * should be picked up and then taken to their destination.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Demo
{
    private List<Actor> actors;
    private int step;

    /**
     * Constructor for objects of class Demo
     */
    public Demo()
    {
        actors = new LinkedList<>();
        step = 0;
        reset();
    }

    /**
     * Run the demo for a fixed number of steps.
     */
    public void run()
    {
        System.out.println("Welcome to our application!");
        for(int i = 0; i < 500; i++){
            step++;
            step();
        }
        System.out.println("All journeys finished.");
    }

    /**
     * Run the demo for one step by requesting
     * all actors to act.
     */
    public void step()
    {
        for(Actor actor : actors) {
            actor.act();
        }
    }

    /**
     * Reset the demo to a starting point.
     * A single taxi is created, and a pickup is
     * requested for a single passenger.
     * @throws IllegalStateException If a pickup cannot be found
     */
    public void reset()
    {
        actors.clear();
        City city = new City();
        TaxiCompany company = new TaxiCompany(city);
        PassengerSource source = new PassengerSource(city, company);
        actors.addAll(company.getVehicles());
        actors.add(source);
    }
}
