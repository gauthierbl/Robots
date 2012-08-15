package org.lab304.robots.bots;

import org.lab304.robots.location.Location;

/**
 * Class description.
 */
public abstract class AbstractRobot implements Robot {

    private String id;
    private String type;

    private Location myLocation;
    private int speed;

    public AbstractRobot() {
        this("", "", 0);
    }


    public AbstractRobot(String id, String type, int speed) {
        this.id = id;
        this.type = type;
        this.speed = speed;
    }

    @Override
    public final void move(Location newLocation) {
        //TODO: other code might go here to confirm move
        setLocation(newLocation);
    }

    @Override
    public final String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", myLocation=" + myLocation +
                ", speed=" + speed +
                '}';
    }

    @Override
    public final String getType() {
        return type;
    }

    @Override
    public final Location getLocation() {
        return myLocation;
    }

    @Override
    public final void setLocation(Location newLocation) {
        myLocation = newLocation;
    }

    @Override
    public final int getSpeed() {
        return speed;
    }

    @Override
    public String display() {
        return id;
    }
}
