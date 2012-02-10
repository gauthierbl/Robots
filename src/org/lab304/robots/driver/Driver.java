package org.lab304.robots.driver;

import org.lab304.robots.bots.Robot;
import org.lab304.robots.bots.impl.EastWalker;
import org.lab304.robots.bots.impl.NorthWalker;
import org.lab304.robots.location.Location;
import org.lab304.robots.simulator.Simulator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class description.
 */
public class Driver {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Robot eastWalkingRobot = new EastWalker();
        Robot northWalkingRobot = new NorthWalker();


        eastWalkingRobot.setLocation(new Location(1, 2));
        northWalkingRobot.setLocation(new Location(2, 1));

        Collection<Robot> robots = new ArrayList<Robot>();
        robots.add(eastWalkingRobot);
        robots.add(northWalkingRobot);

        Simulator sim = new Simulator(robots);

        sim.start();

    }
}
