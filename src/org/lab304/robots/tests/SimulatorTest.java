package org.lab304.robots.tests;


import org.junit.Before;
import org.junit.Test;
import org.lab304.robots.bots.Robot;
import org.lab304.robots.bots.impl.NorthWalker;
import org.lab304.robots.location.Location;
import org.lab304.robots.simulator.Simulator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


/**
 * Class description.
 */
public class SimulatorTest {
    Simulator sim;
    List<Robot> robots;
    Robot robot;

    @Before
    public void setUp() throws Exception {
        sim = new Simulator();
        robots = new ArrayList<Robot>();

        robot = new NorthWalker();

        robots.add(robot);
    }


    @Test
    public void testMoveRobots() throws Exception {

        Location startLocation = new Location(1, 1);
        robot.setLocation(startLocation);

        // the northWalkingRobot is at the start location
        assertEquals(startLocation, robot.getLocation());

        // move the northWalkingRobot
        sim.moveRobots(robots);

        // did the northWalkingRobot move?
        assertNotSame(startLocation, robot.getLocation());
    }
}
