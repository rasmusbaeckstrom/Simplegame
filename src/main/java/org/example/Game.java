package org.example;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Maze maze = new Maze(50, 25);
        Player player = new Player("Rasmus", 1, 12, 100, 10, null);
        Monster monster = new Monster(25, 12, 50, 5);
        Treasure treasure = new Treasure(48, 12);

        maze.setPlayerPosition(player.getX(), player.getY());
        maze.setMonsterPosition(monster.getX(), monster.getY());
        treasure.placeTreasure(maze);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean gameRunning = true;

        while (gameRunning) {
            maze.printMaze();
            System.out.println("Type in your move! use: W A S D: ");
            String direction = scanner.nextLine();
            player.move(direction, maze);

            // Check if player encounters the monster after moving
            if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
                System.out.println("You encountered a monster! Game over.");
                gameRunning = false;
                continue;
            }

            // Move the monster
            String[] directions = {"w", "s", "a", "d"};
            String monsterDirection = directions[random.nextInt(directions.length)];
            monster.move(monsterDirection, maze);

            // Check if monster encounters the player after moving
            if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
                System.out.println("You encountered a monster! Game over.");
                gameRunning = false;
            } else if (player.getX() == treasure.getX() && player.getY() == treasure.getY()) {
                System.out.println("You found the treasure! You win!");
                gameRunning = false;
            }
        }

        scanner.close();
    }
}