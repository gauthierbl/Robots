package org.lab304.robots.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.lab304.robots.bots.Robot;
import org.lab304.robots.bots.impl.SouthWalker;
import org.lab304.robots.location.Location;

import static org.junit.Assert.assertEquals;

/**
 * Class description.
 */
public class SouthWalkerTest {
    Robot southWalkingRobot;

    @Before
    public void setUp() throws Exception {
        southWalkingRobot = new SouthWalker();
    }

    @Test
    public void testDetermineNextLocation() throws Exception {

        Location startLocation = new Location(1, 1);
        Location expectedLocation = new Location(1, 2);
      //  southWalkingRobot.setLocation(startLocation);

        // The southWalkingRobot is at the start location.
  //      assertEquals(startLocation, southWalkingRobot.getLocation());

        // get the southWalkingRobot determined location
        Location determinedLocation = southWalkingRobot.determineNextLocation();

        // Did the southWalkingRobot determine the expected location?
        assertEquals(expectedLocation, determinedLocation);
    }

    @Test
    @Ignore
    public void testDetermineNextLocation_loop10Times() throws Exception {

        Location startLocation = new Location(0, 0);
    //    southWalkingRobot.setLocation(startLocation);

        // The southWalkingRobot is at the start location.
  //      assertEquals(startLocation, southWalkingRobot.getLocation());

        for (int i = 0; i < 10; i++) {
            Location expectedLocation = new Location(0, i + 1);

            // get the southWalkingRobot determined location
            Location determinedLocation = southWalkingRobot.determineNextLocation();
       //     southWalkingRobot.move(determinedLocation);

            // Did the southWalkingRobot determine the expected location?
            assertEquals(expectedLocation, determinedLocation);
        }

    }
}
