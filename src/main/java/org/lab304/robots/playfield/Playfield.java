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
import java.util.Map;

/**
 * Class description.
 */
public class PlayField {

    // todo: add error checking to make sure the PlayField is the size the header says it is.
    // TODO: some unit test would be nice.
    // Review: make a PlayFieldReader to read in a PlayField.

    private Hashtable<Location, Tile> tiles = new Hashtable<Location, Tile>();
    private Hashtable<String, Robot> robots = new Hashtable<String, Robot>();

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
                Location currentLocation = new Location(x, y);
                Tile tile = tiles.get(currentLocation);

                Hashtable<Direction, Tile> neighbors = new Hashtable<Direction, Tile>();

                // make neighbor locations, index by direction
                Map<Direction, Location> neighborLocations = makeNeighborLocations(currentLocation);

                // get tiles for neighbor locations
                for (Direction direction : neighborLocations.keySet()) {
                    Location location = neighborLocations.get(direction);

                    // get the tile at that location
                    Tile neighborTile = tiles.get(location);

                    // put the neighborTile into the map
                    neighbors.put(direction, neighborTile);
                }

                // add tile to current tiles neighbor slot
                tile.setNeighbors(neighbors);
            }
        }
    }

    private Map<Direction, Location> makeNeighborLocations(Location currentLocation) {
        Map<Direction, Location> result = new Hashtable<Direction, Location>();

        result.put(Direction.NORTH, makeNeighborLocation(Direction.NORTH, currentLocation));
        result.put(Direction.NORTHEAST, makeNeighborLocation(Direction.NORTHEAST, currentLocation));
        result.put(Direction.EAST, makeNeighborLocation(Direction.EAST, currentLocation));
        result.put(Direction.SOUTHEAST, makeNeighborLocation(Direction.SOUTHEAST, currentLocation));
        result.put(Direction.SOUTH, makeNeighborLocation(Direction.SOUTH, currentLocation));
        result.put(Direction.SOUTHWEST, makeNeighborLocation(Direction.SOUTHWEST, currentLocation));
        result.put(Direction.WEST, makeNeighborLocation(Direction.WEST, currentLocation));
        result.put(Direction.NORTHWEST, makeNeighborLocation(Direction.NORTHWEST, currentLocation));

        return result;
    }

    private Location makeNeighborLocation(Direction direction, Location currentLocation) {

        Location result = null;
        int currentX = currentLocation.getX();
        int currentY = currentLocation.getY();

        // REVIEW: This is ugly. Is there a better way?
        // TODO the wraparound is not working for -1 cases
        if (Direction.NORTH == direction) {
            result = new Location(currentX, decrementY(currentY));
        } else if (Direction.NORTHEAST == direction) {
            result = new Location(incrementX(currentX), decrementY(currentY));
        } else if (Direction.EAST == direction) {
            result = new Location(incrementX(currentX), currentY);
        } else if (Direction.SOUTHEAST == direction) {
            result = new Location(incrementX(currentX), incrementY(currentY));
        } else if (Direction.SOUTH == direction) {
            result = new Location(currentX, incrementY(currentY));
        } else if (Direction.SOUTHWEST == direction) {
            result = new Location(decrementX(currentX), incrementY(currentY));
        } else if (Direction.WEST == direction) {
            result = new Location(decrementX(currentX), currentY);
        } else if (Direction.NORTHWEST == direction) {
            result = new Location(decrementX(currentX), decrementY(currentY));
        }

        return result;
    }

    private int decrementX(int currentX) {
        return decrementCoordinate(currentX, maxX());
    }

    private int maxX() {
        return cols - 1;
    }

    private int maxY() {
        return rows - 1;
    }

    private int incrementX(int currentX) {
        return incrementCoordinate(currentX, maxX());
    }

    private int decrementY(int currentY) {
        return decrementCoordinate(currentY, maxY());
    }

    private int incrementY(int currentY) {
        return incrementCoordinate(currentY, maxY());
    }

    private int decrementCoordinate(int value, int max) {
        int result = value - 1;

        if (result < 0) {
            result = max;
        }

        return result;
    }

    private int incrementCoordinate(int value, int max) {
        int result = value + 1;

        if (result > max) {
            result = 0;
        }

        return result;
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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(tiles.get(new Location(j, i)).display());
            }
            System.out.println();
        }
    }

    public void placeRobot(Robot bot, Location location) {

        if (!robots.containsKey(bot.getId())) {
            // new robot to playfield
            robots.put(bot.getId(), bot);
        } else {
            // existing robot on playfield, remove bot from old location
            tiles.get(bot.getLocation()).setRobot(null);
        }

        // add bot to new location
        tiles.get(location).setRobot(bot);

        // inform robot of new location
        bot.move(location);
    }

    public boolean locationExists(Location location) {
        return tiles.containsKey(location);
    }
}
