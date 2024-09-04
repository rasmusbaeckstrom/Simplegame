package org.example;

public class Player implements Movable {
    private String name;
    private int x;
    private int y;
    private int health;
    private int strength;
    private Item item;

    public Player(String name, int x, int y, int health, int strength, Item item) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = health;
        this.strength = strength;
        this.item = item;
    }

    @Override
    public void move(String direction, Maze maze) {
        int newX = x;
        int newY = y;

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

        if (!maze.isWall(newX, newY)) {
            x = newX;
            y = newY;
            maze.setPlayerPosition(x, y);
        } else {
            System.out.println("You hit a wall!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}