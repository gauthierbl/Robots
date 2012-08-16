package org.lab304.robots.driver;

import org.lab304.robots.bots.Robot;
import org.lab304.robots.bots.impl.EastWalker;
import org.lab304.robots.location.Location;
import org.lab304.robots.playfield.PlayField;

import java.io.IOException;

/**
 * Class description.
 */
public class PlayFieldDriver {
    public static void main(String[] args) throws IOException {
        PlayField p = new PlayField();

        p.loadPlayfieldFromFile("./src/main/resources/SimplePlayfield.txt");

        Robot bot = new EastWalker();

        p.placeRobot(bot, new Location(0,0));
        p.printPlayField();
        System.out.println();

        p.placeRobot(bot, bot.determineNextLocation());
        p.printPlayField();
        System.out.println();

    }
}
