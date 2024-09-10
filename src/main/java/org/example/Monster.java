package org.example;

public class Monster extends Item implements Movable, Obstacle {
    private int health;
    private int strength;

    public Monster(int x, int y, int health, int strength) {
        super(x, y);
        this.health = health;
        this.strength = strength;
    }

    @Override
    public void move(String direction, Maze maze) {
        int newX = getX();
        int newY = getY();

        switch (direction.toLowerCase()) {
            case "w":
                newY--;
                break;
            case "s":
                newY++;
                break;
            case "a":
                newX--;
                break;
            case "d":
                newX++;
                break;
        }

        if (!maze.isObstacle(newX, newY)) {
            setX(newX);
            setY(newY);
        }
    }

    @Override
    public boolean isObstacle(int x, int y) {
        return getX() == x && getY() == y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}