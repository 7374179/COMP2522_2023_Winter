package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.ArrayList;

public class Basic_01_MySolution {
//    This example defines a Player class with attributes
//    such as id, name, x, y, and moveCount.
//    It also defines a PlayerManager class that manages a list of players
//    and provides methods to add and get players.
//    The main method demonstrates how to use the classes by creating two players,
//    moving them to different positions,
//    and then printing out their current positions.
    ArrayList<Player> players;

    /**
     * Constructor for a PlayerManager.
     */
    public Basic_01_MySolution() {
        this.players = new ArrayList<Player>();
    }

    /**
     * Creates a new Player from a name and adds it to the player list.
     *
     * @param name string
     */
    public void add(String name) {
        Player player = new Player(name);
        players.add(player);
    }

    /**
     * Get a Player by name.
     *
     * @param name string
     * @return the player if exists, null otherwise
     */
    public Player get(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Basic_01_MySolution playerManager = new Basic_01_MySolution();
        playerManager.add("John");
        playerManager.add("Jane");

        playerManager.get("John").move(10, 20);
        playerManager.get("Jane").move(30, 40);

        System.out.println("Player " + playerManager.get("John").getName()
                + " is at (" + playerManager.get("John").getX() + ", " + playerManager.get("John").getY() + ")");
        System.out.println("Player " + playerManager.get("Jane").getName()
                + " is at (" + playerManager.get("Jane").getX() + ", " + playerManager.get("Jane").getY() + ")");
    }
}

class Player {
    private static int count = 0;
    private final int id;
    private final String name;
    private int x;
    private int y;
    private int moveCount;

    public Player(String name) {
        this.id = ++count;
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.moveCount = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCount() {
        return moveCount;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        this.moveCount++;
    }
}
