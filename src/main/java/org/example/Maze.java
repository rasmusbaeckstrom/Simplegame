package org.example;

import java.util.ArrayList;

public class Maze {
    private final ArrayList<ArrayList<Character>> structure;
    private int playerX, playerY;
    private int monsterX, monsterY;

    public Maze(int width, int height) {
        structure = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add(' ');
            }
            structure.add(row);
        }
        // Add walls to the maze
        for (int i = 0; i < width; i++) {
            structure.get(0).set(i, '#'); // Top wall
            structure.get(height - 1).set(i, '#'); // Bottom wall
        }
        for (int i = 0; i < height; i++) {
            structure.get(i).set(0, '#'); // Left wall
            structure.get(i).set(width - 1, '#'); // Right wall
        }
        // Add some internal walls
        structure.get(2).set(2, '#');
        structure.get(2).set(3, '#');
        structure.get(3).set(2, '#');
    }

    public boolean isWall(int x, int y) {
        return structure.get(y).get(x) == '#';
    }

    public void setPlayerPosition(int x, int y) {
        playerX = x;
        playerY = y;
    }

    public void setMonsterPosition(int x, int y) {
        monsterX = x;
        monsterY = y;
    }

    public void setTreasure(Treasure treasure) {
        structure.get(treasure.getY()).set(treasure.getX(), 'T');
    }

    public void printMaze() {
        for (int y = 0; y < structure.size(); y++) {
            for (int x = 0; x < structure.get(y).size(); x++) {
                if (x == playerX && y == playerY) {
                    System.out.print('P'); // Player symbol
                } else if (x == monsterX && y == monsterY) {
                    System.out.print('M'); // Monster symbol
                } else {
                    System.out.print(structure.get(y).get(x));
                }
            }
            System.out.println();
        }
    }
}