package org.lab304.robots.simulator;

import org.lab304.robots.bots.Robot;
import org.lab304.robots.location.Location;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class description.
 */
public class Simulator implements Runnable {

    Collection<Robot> robots;
    private boolean alive = false;
    private Thread controlThread;

    public Simulator() {
        this(new ArrayList<Robot>());
    }

    public Simulator(Collection<Robot> robots) {
        this.robots = robots;
        controlThread = new Thread(this);
    }

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

    public void start() {
        controlThread.start();
        alive = true;
    }

    @Override
    public void run() {

        while (alive) {
            moveRobots(robots);
            printOutBots(robots);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printOutBots(Collection<Robot> robots) {

        for (Robot robot : robots) {
            System.out.println(robot);
        }
    }
}
