package src.main.java.org.bcit.midterm.mysolution;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Intermediate_02_MySolution {
//  This Java package defines classes for a 2D game, including an abstract "Intermediate_01_Sprite" class
//  with attributes for position, direction, speed, and collision handling.
//  It also includes "Intermediate_01_Invader" and "Intermediate_01_Player" subclasses
//  of "Intermediate_01_Sprite" for enemy and player sprites, respectively. The "Intermediate_01_Window" class
//  represents the game window and contains references to all sprites.
//  Additionally, there are interfaces for moving, colliding, and shooting sprites.
  public abstract class Intermediate_02_Sprite {
    private PVector postion;
    private PVector direction;
    private float speed;
    private Window window;
    public int position;

    public void collide() { }

    public PVector getDirection() { return null; }

    public Pvector getPosition() { return null; }

    public boolean collided(Intermediate_02_Sprite a, Intermediate_02_Sprite b) { return true; }

    public void draw() { }

    public void setDirection(PVector direction) { }
  }

  public class Intermediate_02_Invader extends Intermediate_02_Sprite{
    private Pvector position;
    private PVector direction;
    private Window window;
    public void Move(KeyEvent event){}
    public void shoot(){}
    public void collide(){}
  }

  public class Intermediate_02_Player extends Intermediate_02_Sprite{
    private PVector postion;
    private PVector direction;
    private float speed;
    private Window window;
    public void move(keyEvent event){}
    public void shoot(){}
    public boolean collided(Intermediate_02_Sprite a, Intermediate_02_Sprite b){}
  }

  public class Intermediate_02_Window{
    public ArrayList<Intermediate_02_Sprite> sprites;
    public ArrayList<Intermediate_02_Sprite> invaders;
    public Intermediate_02_Sprite player;
    public int numinvaders;
    public void keyPressed(KeyEvent event){}
    public void draw(){}
    public void remove(Intermediate_02_Sprite s){}
    public void main(String[] args){}
  }

}
