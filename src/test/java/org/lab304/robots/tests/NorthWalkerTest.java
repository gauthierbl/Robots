package org.lab304.robots.tests;

import org.junit.Before;
import org.junit.Test;
import org.lab304.robots.bots.Robot;
import org.lab304.robots.bots.impl.NorthWalker;
import org.lab304.robots.location.Location;

import static org.junit.Assert.assertEquals;

/**
 * Class description.
 */
public class NorthWalkerTest {
    Robot northWalkingRobot;

    @Before
    public void setUp() throws Exception {
        northWalkingRobot = new NorthWalker();
    }

    @Test
    public void testDetermineNextLocation() throws Exception {

        Location startLocation = new Location(1, 1);
        Location expectedLocation = new Location(2, 1);
        northWalkingRobot.setLocation(startLocation);

        // the northWalkingRobot is at the start location
        assertEquals(startLocation, northWalkingRobot.getLocation());

        // get the northWalkingRobot determined location
        Location determinedLocation = northWalkingRobot.determineNextLocation();

        // did the northWalkingRobot determine the expected location
        assertEquals(expectedLocation, determinedLocation);
    }
}
