package org.bcit.comp2522.labs.lab03;

/**
 * Ability interface.
 *
 * @author Tae Hyung Lee and Taehyuk Chung
 * @version 2023, January 23rd
 */
public interface Ability {

  boolean collided(Sprite other);

  void draw();

  void bounce();
}