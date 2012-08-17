package org.lab304.robots.bots.impl;

import org.lab304.robots.bots.AbstractRobot;
import org.lab304.robots.location.Location;
import org.lab304.robots.playfield.tile.Tile;

/**
 * Class description.
 */
public class SouthWalker extends AbstractRobot {

    public SouthWalker() {
        super("S", "SouthWalker", 1);
    }

    @Override
    public Location determineNextLocation() {
        Tile southTile = this.getTile().getSouthNeighborTile();
        return southTile.getLocation();
    }
}
