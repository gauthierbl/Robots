package org.lab304.robots.playfield.tile;

/**
 * Class description.
 */
public enum TileType {
    LAND (1, '.');


    private final int id;
    private final char symbol;

    private TileType(int id, char symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public char display() {
        return symbol;
    }
}
