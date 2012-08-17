package org.lab304.robots.bots;

import org.lab304.robots.location.Location;
import org.lab304.robots.playfield.tile.Tile;

/**
 * Class description.
 */
public interface Robot {


    public void hasMovedTo(Tile newTile);

    public Location determineNextLocation();

    public String getId();

    public String getType();

    public Tile getTile();

    public void setTile(Tile tile);

    public int getSpeed();

    public String display();
}
