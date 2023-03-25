package src.main.java.org.bcit.midterm.mysolution;

import java.util.ArrayList;

public class Basic_01_PlayerManager {
  // Basic Question 01 (5 points, 3 TODOs)
  // Idea: tests your ability to create classes that persist state.

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Basic_01_myClass. Name them something useful,
  // other than "myClass", that is just an example.

  // TODO 1: Create a new Basic_01_Player class that persists the
  // following state as class attributes:
  // (1) A unique integer ID generated on construction.
  // (2) A String label passed during construction.
  // (3) A float X and a float Y position.
  // (4) An integer count of how many times it's been moved.
  //
  // You MAY modify this class if you need to, but it is not required.

  // TODO 2: Define a move method in Basic_01_Player that resets the
  // X and Y position to given values and increments the move count by 1

  ArrayList<Basic_01_Player> players;

  /**
   * Constructor for a PlayerManager.
   */
  public Basic_01_PlayerManager() {
    this.players = new ArrayList<Basic_01_Player>();
  }

  /**
   * Creates a new Basic_01_Player from a label
   * @param label string
   */
  public void add(String label) {
    Basic_01_Player player = new Basic_01_Player(label);
    players.add(player);
  }

  /**
   * Get a Basic_01_Player by label
   * @param label string
   * @return the player if exists, null otherwise
   */
  public Basic_01_Player get(String label) {
    for (Basic_01_Player player : players) {
      if (player.label == label) {
        return player;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Basic_01_PlayerManager playerManager = new Basic_01_PlayerManager();
    playerManager.add("Sleve McDichael"); // id needs to be different than players below
    playerManager.add("Onson Sweemy"); // id needs to be different than player above
    playerManager.add("Darryl Archideld"); // id needs to be different than players above

    playerManager.get("Sleve McDichael").move(34f, 55f);
    // state should be:
    // - id: <some unique integer>
    // - label: "Sleve McDichael"
    // - x: 34f
    // - y: 55f
    // - moveCount: 1
      System.out.println("Player " + playerManager.get("Sleve McDichael").label + " with ID " + playerManager.get("Sleve McDichael").id
              + " is at (" + playerManager.get("Sleve McDichael").x + ", " + playerManager.get("Sleve McDichael").y + ") and has moved "
              + playerManager.get("Sleve McDichael").count + " times.");

    playerManager.get("Sleve McDichael").move(100f, 234f);
    // state should be:
    // - id: <some unique integer>
    // - label: "Sleve McDichael"
    // - x: 100f
    // - y: 234f
    // - moveCount: 2

    for (Basic_01_Player player : playerManager.players) {
      System.out.println("Player " + player.label + " with ID " + player.id
              + " is at (" + player.x + ", " + player.y + ") and has moved "
              + player.count + " times.");
    }
  }
}
