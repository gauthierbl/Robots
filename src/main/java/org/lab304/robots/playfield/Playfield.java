package org.lab304.robots.playfield;

import org.lab304.robots.bots.Robot;
import org.lab304.robots.direction.Direction;
import org.lab304.robots.location.Location;
import org.lab304.robots.playfield.tile.Tile;
import org.lab304.robots.playfield.tile.TileType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Class description.
 */
public class Playfield {

    // todo: add error checking to make sure the palyfield is the size the header says it is.
    // Review: make a PlayfieldReader to read in a playfield.

    private Hashtable<Location, Tile> tiles = new Hashtable<Location, Tile>();
    private Hashtable<String, Robot> robots;

    int rows; // the Y
    int cols; // the X


    public void loadPlayfieldFromFile(String fileName) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        int x = 0;
        int y = 0;


        String line;

        //read the header data about how big the playfield is
        rows = readRows(input.readLine());
        cols = readCols(input.readLine());

        System.out.println("rows=" + rows);
        System.out.println("cols=" + cols);

        //skip a line in the file
        input.readLine();

        //start reading the playfield
        while ((line = input.readLine()) != null) {
            x = 0;
            for (char c : line.toCharArray()) {
                System.out.print(c);
                Tile tile = new Tile();

                tile.setLocation(new Location(x, y));
                tile.setType(getTypeFromData(c));

                x++;

                tiles.put(tile.getLocation(), tile);
            }
            y++;
            System.out.println();
        }

        setupTileLinks();


    }

    private void setupTileLinks() {
        // todo: setup tile links
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                //get the current title
                Tile tile = tiles.get(new Location(x, y));

                Hashtable<Direction, Tile> neighbors = new Hashtable<Direction, Tile>();

                //get the neighbor tiles
//                Tile n = map[(row+rows-1)%rows][col];
//                Tile e = map[row][(col+1)%cols];
//                Tile s = map[(row+1)%rows][col];
//                Tile w = map[row][(col+cols-1)%cols];

            }
        }
    }

    private int readRows(String rowsData) {
        return Integer.parseInt(rowsData);
    }

    private int readCols(String colsData) {
        return Integer.parseInt(colsData);
    }

    private TileType getTypeFromData(char c) {
        // Todo: based on the char c determine the TileType
        return TileType.LAND;
    }

    public void printPlayField() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(tiles.get(new Location(j, i)));
            }
            System.out.println();
        }
    }


}
