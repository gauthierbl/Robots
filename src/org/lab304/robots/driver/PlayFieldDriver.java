package org.lab304.robots.driver;

import org.lab304.robots.playfield.Playfield;

import java.io.IOException;

/**
 * Class description.
 */
public class PlayFieldDriver {
    public static void main(String[] args) throws IOException {
        Playfield p = new Playfield();

        p.loadPlayfieldFromFile("./data/SimplePlayfield.txt");

        p.printPlayField();

    }
}
