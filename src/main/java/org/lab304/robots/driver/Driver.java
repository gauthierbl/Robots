package org.lab304.robots.driver;

import org.lab304.robots.bots.Robot;
import org.lab304.robots.bots.impl.SouthWalker;
import org.lab304.robots.bots.impl.EastWalker;
import org.lab304.robots.location.Location;
import org.lab304.robots.playfield.PlayField;
import org.lab304.robots.playfield.tile.Tile;
import org.lab304.robots.simulator.Simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class description.
 */
public class Driver {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        PlayField playField = new PlayField();

        playField.loadPlayFieldFromFile("./src/main/resources/PlayField.txt");

        Robot southWalkingRobot = new SouthWalker();
        Robot eastWalkingRobot = new EastWalker();

        // FIXME
        Tile eastStartTile = playField.getTile(new Location(1,2));
        Tile southStatTile = playField.getTile(new Location(2,1));

        eastWalkingRobot.setTile(eastStartTile);
        southWalkingRobot.setTile(southStatTile);

        Collection<Robot> robots = new ArrayList<Robot>();
        robots.add(eastWalkingRobot);
        robots.add(southWalkingRobot);

        Simulator sim = new Simulator(robots, playField);

        sim.start();

    }
}
