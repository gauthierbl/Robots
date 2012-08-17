package org.lab304.robots.bots.impl;

import org.lab304.robots.bots.AbstractRobot;
import org.lab304.robots.location.Location;
import org.lab304.robots.playfield.tile.Tile;

/**
 * Class description.
 */
public class EastWalker extends AbstractRobot {

    public EastWalker() {
        super("E", "EastWalker", 1);
    }


    @Override
    public Location determineNextLocation() {
        Tile eastTile = this.getTile().getEastNeighborTile();
        return eastTile.getLocation();
    }
}
