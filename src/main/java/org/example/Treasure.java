package org.example;

public class Treasure extends Item {
    public Treasure(int x, int y) {
        super(x, y);
    }

    public void placeTreasure(Maze maze) {
        maze.setTreasure(this);
    }
}