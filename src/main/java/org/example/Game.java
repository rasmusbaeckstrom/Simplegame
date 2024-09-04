package org.example;

public class Game {
    public static void main(String[] args) {

        Item item = new Item(0,0);
        Player player = new Player("", 0, 0, 0, 0, item);
        Sword sword = new Sword(0, 0, "");

        player.setName("Rasmus");
        player.setX(5);
        player.setY(10);
        player.setHealth(100);
        player.setStrength(10);

        item.setX(10);
        item.setY(20);

        sword.setMaterial("Steel");
        sword.setX(15);
        sword.setY(30);

        System.out.println("Player name: " + player.getName());
        System.out.println("Player position X: " + player.getX());
        System.out.println("Player position Y: " + player.getY());
        System.out.println("Player health: " + player.getHealth());
        System.out.println("Player strength: " + player.getStrength());

        System.out.println("Item x: " + item.getX());
        System.out.println("Item y: " + item.getY());

        System.out.println("Sword material: " + sword.getMaterial());
        System.out.println("Sword x: " + sword.getX());
        System.out.println("Sword y: " + sword.getY());
    }
}