package org.example;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final ArrayList<ArrayList<String>> structure;
    private int playerX, playerY;
    private final List<Obstacle> obstacles = new ArrayList<>();
    private final List<Monster> monsters = new ArrayList<>();

    public Maze(int width, int height) {
        structure = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add("  "); // Two spaces for empty cells
            }
            structure.add(row);
        }
        // Add walls to the maze
        addHorizontalWall(0, 0, width); // Top wall
        addHorizontalWall(height - 1, 0, width); // Bottom wall
        addVerticalWall(0, 0, height); // Left wall
        addVerticalWall(width - 1, 0, height); // Right wall

        // Add internal walls
        addVerticalWall(5, 3, 4);
        addHorizontalWall(6, 5, 11);
        addVerticalWall(20, 1, 10);
        addHorizontalWall(10, 15, 6);
        addVerticalWall(5, 15, 4);
        addHorizontalWall(15, 5, 11);
        addVerticalWall(10, 5, 5);
        addHorizontalWall(20, 10, 6);
        addVerticalWall(15, 20, 3);
        addHorizontalWall(8, 25, 10);
        addVerticalWall(30, 5, 10);
        addHorizontalWall(18, 10, 12);
        addVerticalWall(25, 15, 5);
        addHorizontalWall(22, 30, 10);
        addVerticalWall(35, 10, 9);
        addHorizontalWall(18, 36, 9);
        addHorizontalWall(12, 5, 8);
        addVerticalWall(40, 3, 8);
        addHorizontalWall(16, 20, 10);
        addVerticalWall(45, 10, 5);
        addHorizontalWall(24, 5, 15);
        addVerticalWall(10, 18, 3);
        addHorizontalWall(3, 35, 5);
    }

    private void addHorizontalWall(int y, int startX, int length) {
        for (int x = startX; x < startX + length; x++) {
            structure.get(y).set(x, "█ ");
            obstacles.add(new Wall(x, y));
        }
    }

    private void addVerticalWall(int x, int startY, int length) {
        for (int y = startY; y < startY + length; y++) {
            structure.get(y).set(x, "█ ");
            obstacles.add(new Wall(x, y));
        }
    }

    public boolean isObstacle(int x, int y) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.isObstacle(x, y)) {
                return true;
            }
        }
        return false;
    }

    public void setPlayerPosition(int x, int y) {
        playerX = x;
        playerY = y;
    }

    public void addMonsterPosition(Monster monster) {
        monsters.add(monster);
        obstacles.add(monster);
    }

    public void updateMonsterPosition(int index, int x, int y) {
        Monster monster = monsters.get(index);
        monster.setX(x);
        monster.setY(y);
    }

    public void setTreasure(Treasure treasure) {
        structure.get(treasure.getY()).set(treasure.getX(), "T ");
    }

    public void printMaze() {
        for (int y = 0; y < structure.size(); y++) {
            for (int x = 0; x < structure.get(y).size(); x++) {
                if (x == playerX && y == playerY) {
                    System.out.print("P ");
                } else {
                    boolean isMonster = false;
                    for (Monster monster : monsters) {
                        if (monster.isObstacle(x, y)) {
                            System.out.print("M ");
                            isMonster = true;
                            break;
                        }
                    }
                    if (!isMonster) {
                        System.out.print(structure.get(y).get(x));
                    }
                }
            }
            System.out.println();
        }
    }
}