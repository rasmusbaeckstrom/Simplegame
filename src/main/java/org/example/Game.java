package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Maze maze = new Maze(50, 25);
        Player player = new Player("Rasmus", 1, 12, 100, 10, null);
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster(25, 12, 50, 5));
        monsters.add(new Monster(30, 15, 50, 5));
        monsters.add(new Monster(8, 20, 50, 5));
        monsters.add(new Monster(38, 5, 50, 5));
        monsters.add(new Monster(38, 20, 50, 5));
        monsters.add(new Monster(8, 10, 50, 5));
        Treasure treasure = new Treasure(48, 12);

        maze.setPlayerPosition(player.getX(), player.getY());
        for (Monster monster : monsters) {
            maze.addMonsterPosition(monster);
        }
        treasure.placeTreasure(maze);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean gameRunning = true;

        while (gameRunning) {
            maze.printMaze();
            System.out.println("Type in your move! use: W A S D: ");
            String direction = scanner.nextLine();
            player.move(direction, maze);

            // Check if player encounters any monster after moving
            for (Monster monster : monsters) {
                if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
                    System.out.println("You encountered a monster! Game over.");
                    gameRunning = false;
                    break;
                }
            }

            if (!gameRunning) continue;

            // Move each monster
            String[] directions = {"w", "s", "a", "d"};
            for (int i = 0; i < monsters.size(); i++) {
                Monster monster = monsters.get(i);
                String monsterDirection = directions[random.nextInt(directions.length)];
                monster.move(monsterDirection, maze);
                maze.updateMonsterPosition(i, monster.getX(), monster.getY());

                // Check if any monster encounters the player after moving
                if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
                    System.out.println("You encountered a monster! Game over.");
                    gameRunning = false;
                    break;
                }
            }

            if (player.getX() == treasure.getX() && player.getY() == treasure.getY()) {
                System.out.println("You found the treasure! You win!");
                gameRunning = false;
            }
        }

        scanner.close();
    }
}