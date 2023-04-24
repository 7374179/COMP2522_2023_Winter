package org.bcit.comp2522.winter2023.midterm.questions;

public class Basic_03_CoffeeMaker {
  // Basic Question 03 (5 points, 2 TODOs)
  // Idea: tests your ability to create super/sub classes

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Basic_03_myClass. Name them something useful,
  // other than "myClass", that is just an example.

  float waterLevel;
  float coffeeLevel;

  public void fill(float millileters ) {
    this.waterLevel += millileters;
    // this coffee pot cannot be filled above 1000 millileters
    if (this.waterLevel > 1000f) {
      this.waterLevel = 1000f;
    }
  }

  public void makeCoffee() {
    while (this.waterLevel > 0f) {
      System.out.format("Coffee is at %d millileters...\n", this.coffeeLevel);
      this.coffeeLevel += 1f;
      this.waterLevel -= 1f;
      try {
        Thread.sleep(15);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("Coffee is done!!");
  }

  // TODO 1: Create a subclass that EXTENDS this class by adding
  // a new core functionality: starting a timer for making coffee at some
  // point in the future. You MUST NOT recreate any functionality that
  // this class already implements. You MUST use this class. You can
  // call this class Basic_03_CoffeeMakerWithTimer.

  public static void main(String[] args) {
    long start = System.nanoTime();
    Basic_03_CoffeeMakerWithTimer coffeeMakerWithTimer = new Basic_03_CoffeeMakerWithTimer();
    // fill the coffee maker with water
    coffeeMakerWithTimer.fill(1010); // coffeeMakerWithTimer.waterLevel == 1000
    // number of miliseconds into the future that we want to make coffee
    coffeeMakerWithTimer.startTimer(1000);
    // should start making coffee 1000 milliseconds later
    // and finish after 15 milliseconds/millileter * 1000 millileters = 15,000 milliseconds
    // for a total run time of 16,000 milliseconds
    long end = System.nanoTime();
    System.out.format("Started at %d and ended at %d for %d milliseconds.", start, end, (end - start)/1000000000);
  }
}
