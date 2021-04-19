package com.david.kata;

/**
 * Contains abcisse and ordonate of edges of are where rover could move
 */
public class Area {

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public Area(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }
}
