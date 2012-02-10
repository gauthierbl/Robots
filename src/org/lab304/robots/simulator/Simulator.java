package org.lab304.robots.simulator;

import org.lab304.robots.bots.Robot;
import org.lab304.robots.location.Location;

import java.util.Collection;

/**
 * Class description.
 */
public class Simulator {

    // TODO: implement

    public void moveRobots(Collection<Robot> robots) {

        for (Robot robot : robots) {
            Location robotNextLocation = robot.determineNextLocation();

            if (isNewLocationValid(robotNextLocation)) {
                robot.move(robotNextLocation);
            } else {
                // review: do we want to tell the bot it made a bad move?
                // robot.failedMove();
            }


        }
    }

    private boolean isNewLocationValid(Location robotNextLocation) {
        boolean result = true;

        // todo: implement all the simulator rules, use a command pattern
        //isDistanceCorrect(robotNextLocation);
        //isLocationOccupied(robotNextLocation);


        return result;
    }
}
