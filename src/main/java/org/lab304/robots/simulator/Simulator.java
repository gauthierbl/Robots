package org.lab304.robots.simulator;

import org.lab304.robots.bots.Robot;
import org.lab304.robots.location.Location;
import org.lab304.robots.playfield.PlayField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Class description.
 */
public class Simulator implements Runnable {

    Collection<Robot> robots;
    private boolean alive = false;
    private Thread controlThread;

    private PlayField playField;

    public Simulator() {
        this(new ArrayList<Robot>(), new PlayField());
    }

    public Simulator(Collection<Robot> robots, PlayField playField) {
        this.robots = robots;
        this.playField = playField;
        controlThread = new Thread(this);
    }

    public void moveRobots(Collection<Robot> robots) {

        for (Robot robot : robots) {
            Location robotNextLocation = robot.determineNextLocation();

            if (isLocationValid(robotNextLocation)) {
                moveRobot(robot, robotNextLocation);
            } else {
                // review: do we want to tell the bot it made a bad move?
                // robot.failedMove();
            }


        }
    }

    private void moveRobot(Robot robot, Location robotNextLocation) {
        playField.placeRobot(robot, robotNextLocation);

        robot.hasMovedTo(playField.getTile(robotNextLocation));
    }

    private boolean isLocationValid(Location location) {
        boolean result;

        // todo: implement all the simulator rules, use a command pattern
        // check to make sure that this location is passable
        //isDistanceCorrect(location);
        //isLocationOccupied(location);

        // make sure this location exists in the playField
        result = playField.locationExists(location);

        return result;
    }

    public void start() {
        controlThread.start();
        alive = true;
    }

    public void placeBotsInPlayField() {
        for (Robot robot : robots) {
            // TODO: determine a random location

            Location startLocation = makeRandomLocation();

            moveRobot(robot, startLocation);
        }
    }

    private Location makeRandomLocation() {
        Random random = new Random();

        int maxX = random.nextInt(playField.getCols());
        int maxY = random.nextInt(playField.getRows());

        return new Location(maxX, maxY);
    }

    @Override
    public void run() {

        placeBotsInPlayField();
        while (alive) {
            moveRobots(robots);
            display();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void display() {
        printPlayField(playField);
        printOutBots(robots);
        System.out.println("======");
    }

    private void printPlayField(PlayField playField) {
        playField.printPlayField();
    }

    private void printOutBots(Collection<Robot> robots) {

        for (Robot robot : robots) {
            System.out.println(robot);
        }
    }
}
