package org.lab304.robots.driver;

import org.lab304.robots.bots.impl.EastWalker;
import org.lab304.robots.location.Location;
import org.lab304.robots.playfield.Playfield;

import java.io.IOException;

/**
 * Class description.
 */
public class PlayFieldDriver {
    public static void main(String[] args) throws IOException {
        Playfield p = new Playfield();

        p.loadPlayfieldFromFile("./src/main/resources/SimplePlayfield.txt");

        p.placeRobot(new Location(0,0), new EastWalker());

        p.printPlayField();

    }
}
