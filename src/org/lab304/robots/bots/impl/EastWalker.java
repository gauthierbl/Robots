package org.lab304.robots.bots.impl;

import org.lab304.robots.bots.AbstractRobot;
import org.lab304.robots.location.Location;

/**
 * Class description.
 */
public class EastWalker extends AbstractRobot {

    public EastWalker() {
        super("1", "EastWalker", 1);
    }

    @Override
    public Location determineNextLocation() {
        int newY = this.getLocation().getY() + this.getSpeed();
        return new Location(this.getLocation().getY(), newY);
    }
}
