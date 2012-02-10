package org.lab304.robots.tests;

import org.junit.Before;
import org.junit.Test;
import org.lab304.robots.bots.Robot;
import org.lab304.robots.bots.impl.EastWalker;
import org.lab304.robots.location.Location;

import static org.junit.Assert.assertEquals;

/**
 * Class description.
 */
public class EastWalkerTest {
    Robot eastWalkingRobot;

    @Before
    public void setUp() throws Exception {
        eastWalkingRobot = new EastWalker();
    }

    @Test
    public void testDetermineNextLocation() throws Exception {

        Location startLocation = new Location(1, 1);
        Location expectedLocation = new Location(1, 2);
        eastWalkingRobot.setLocation(startLocation);

        // The eastWalkingRobot is at the start location.
        assertEquals(startLocation, eastWalkingRobot.getLocation());

        // get the eastWalkingRobot determined location
        Location determinedLocation = eastWalkingRobot.determineNextLocation();

        // Did the eastWalkingRobot determine the expected location?
        assertEquals(expectedLocation, determinedLocation);
    }

    @Test
    public void testDetermineNextLocation_loop10Times() throws Exception {

        Location startLocation = new Location(0, 0);
        eastWalkingRobot.setLocation(startLocation);

        // The eastWalkingRobot is at the start location.
        assertEquals(startLocation, eastWalkingRobot.getLocation());

        for (int i = 0; i < 10; i++) {
            Location expectedLocation = new Location(0, i + 1);

            // get the eastWalkingRobot determined location
            Location determinedLocation = eastWalkingRobot.determineNextLocation();
            eastWalkingRobot.move(determinedLocation);

            // Did the eastWalkingRobot determine the expected location?
            assertEquals(expectedLocation, determinedLocation);
        }

    }
}
