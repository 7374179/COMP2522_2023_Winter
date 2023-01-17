package org.bcit.comp2522.labs.lab03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;



class SpriteTest  {
  Sprite a;

  Sprite b;

  final int minSize = 10;
  Window window;

  @BeforeEach
  void setUp(){
    a = new Sprite(
            new PVector(30/2,30/2),
            new PVector(0,1),
            minSize + 1,
            2,
            new Color(0,255,0),
            this.window);

    b = new Sprite(
            new PVector(30/2,30/2),
            new PVector(0,1),
            minSize + 1,
            2,
            new Color(0,255,0),
            this.window);
  }

  @Test
  void testEquals() {
    assertEquals(a,b);
  }

  @Test
  void testNotEquals(){
    b = new Sprite(
            new PVector(15/2,15/2),
            new PVector(0,1),
            30 + 1,
            2,
            new Color(0,0,255),
            this.window);
    assertNotEquals(a,b);
  }

  @Test
  void compareTo() {
  Assertions.assertEquals(0,a.compareTo(b));
 }
 @Test
  void compareTo2(){
   b = new Sprite(
           new PVector(15/2,15/2),
           new PVector(0,1),
           30 + 1,
           2,
           new Color(0,0,255),
           this.window);
    Assertions.assertEquals(-1,a.compareTo(b));
 }
}