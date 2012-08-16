package org.lab304.robots.bots.impl;

import org.lab304.robots.bots.AbstractRobot;
import org.lab304.robots.location.Location;

/**
 * Class description.
 */
public class SouthWalker extends AbstractRobot {

    public SouthWalker() {
        super("S", "SouthWalker", 1);
    }

    @Override
    public Location determineNextLocation() {
        int newY = this.getLocation().getY() + this.getSpeed();
        return new Location(this.getLocation().getX(), newY);
    }
}
