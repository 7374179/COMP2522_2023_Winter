package ca.bcit.comp2522.labs.lab02;

/**
 * Collidable abstract class.
 *
 * @author Tae Hyung Lee and Taehyuk Chung
 * @version 17.0.4.1
 */
public abstract class Collidable {

  abstract void draw();

  abstract void collide();

  public abstract void move();
}
