package org.lab304.robots.bots;

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
}
