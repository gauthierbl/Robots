package org.lab304.robots.driver;

import org.lab304.robots.bots.Robot;
import org.lab304.robots.bots.impl.SouthWalker;
import org.lab304.robots.bots.impl.EastWalker;
import org.lab304.robots.playfield.PlayField;
import org.lab304.robots.simulator.Simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class description.
 */
public class Driver {

    private static final String playFieldFile = "./src/main/resources/PlayField.txt";

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        PlayField playField = fetchPlayField(playFieldFile);

        Collection<Robot> robots = makeRobots();

        Simulator sim = new Simulator(robots, playField);

        sim.start();
    }

    private static PlayField fetchPlayField(final String fileName) throws IOException {
        PlayField playField = new PlayField();
        playField.loadPlayFieldFromFile(fileName);
        return playField;
    }

    private static Collection<Robot> makeRobots() {
        Robot southWalkingRobot = new SouthWalker();
        Robot eastWalkingRobot = new EastWalker();

        Collection<Robot> robots = new ArrayList<Robot>();
        robots.add(eastWalkingRobot);
        robots.add(southWalkingRobot);
        return robots;
    }
}
