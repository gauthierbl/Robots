package org.lab304.robots.bots;

import org.lab304.robots.playfield.tile.Tile;

/**
 * Class description.
 */
public abstract class AbstractRobot implements Robot {

    private String id;
    private String type;

    private Tile tile;
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
    public final void hasMovedTo(Tile newTile) {
        //TODO: other code might go here to confirm move
        setTile(newTile);
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
                ", location=" + tile.getLocation() +
                ", speed=" + speed +
                '}';
    }

    @Override
    public final String getType() {
        return type;
    }

    @Override
    public Tile getTile() {
        return tile;
    }

    @Override
    public void setTile(Tile tile) {
        this.tile = tile;
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
