package org.example;

public class Wall implements Obstacle {
    private final int x;
    private final int y;

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isObstacle(int x, int y) {
        return this.x == x && this.y == y;
    }
}