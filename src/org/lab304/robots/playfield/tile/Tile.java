package org.lab304.robots.playfield.tile;

import org.lab304.robots.bots.Robot;
import org.lab304.robots.direction.Direction;
import org.lab304.robots.location.Location;

import java.util.Hashtable;

/**
 * Class description.
 */
public class Tile {
    /**
     * The (X,Y) {@link org.lab304.robots.location.Location} of the tile.
     */
    private Location location;

    /**
     * The neighboring {@link Tile}s to this one.
     */
    private Hashtable<Direction, Tile> neighbors = new Hashtable<Direction, Tile>();

    /**
     * The {@link TileType} this Tile is.
     */
    private TileType type = TileType.LAND;

    /**
     * The {@link Robot} that is on this tile. If the does not have a robot this is null.
     */
    private Robot robot = null;

    public Tile() {

    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Hashtable<Direction, Tile> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Hashtable<Direction, Tile> neighbors) {
        this.neighbors = neighbors;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public String toString() {
        return ".";
    }
}
