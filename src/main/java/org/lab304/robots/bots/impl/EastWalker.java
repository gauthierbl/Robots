package org.lab304.robots.bots.impl;

import org.lab304.robots.bots.AbstractRobot;
import org.lab304.robots.location.Location;

/**
 * Class description.
 */
public class EastWalker extends AbstractRobot {

    public EastWalker() {
        super("E", "EastWalker", 1);
    }


    @Override
    public Location determineNextLocation() {
        int newX = this.getLocation().getX() + this.getSpeed();
        return new Location(newX, this.getLocation().getY());
    }
}
