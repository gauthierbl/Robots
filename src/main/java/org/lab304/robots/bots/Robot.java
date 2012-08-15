package org.lab304.robots.bots;

import org.lab304.robots.location.Location;

/**
 * Class description.
 */
public interface Robot {


    public void move(Location newLocation);

    public Location determineNextLocation();

    public String getId();

    public String getType();

    public Location getLocation();

    public void setLocation(Location newLocation);

    public int getSpeed();

    public String display();
}
