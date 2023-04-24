package org.bcit.comp2522.lectures.sl04;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PVector;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
  Player player;
  Window window;
  long uid;

  @BeforeEach
  void setup() {
    window = new Window();
    player = Player.getInstance(
      new PVector(0,0),
      new PVector(0,0),
      10,
      1,
      new Color(10),
      window
    );
    uid = player.getUid();
  }

  @Test
  void instanceTest() {
    Player p1 = Player.getInstance();
    Player p2 = Player.getInstance();
    assertEquals(uid, p1.getUid());
    assertEquals(uid, p2.getUid());
    assertEquals(p1.getUid(), p2.getUid());
  }
}