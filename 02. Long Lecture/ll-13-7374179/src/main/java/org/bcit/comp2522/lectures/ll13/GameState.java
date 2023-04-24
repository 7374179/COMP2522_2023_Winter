package org.bcit.comp2522.lectures.ll13;

import java.util.ArrayList;

public class GameState {
  Player me;
  ArrayList<Player> players;
  GameState(Player me) {
    this.me = me;
    players = new ArrayList<>();
  }

  public void draw(Window w) {
    drawPlayer(w, me);
    for (Player p : players) {
      drawPlayer(w, p);
    }
  }

  public void drawPlayer(Window w, Player p) {
    w.pushStyle();
    w.fill(p.c.getRed(), p.c.getGreen(), p.c.getBlue());
    w.ellipse(p.x, p.y, 10, 10);
    w.popStyle();
  }

}
