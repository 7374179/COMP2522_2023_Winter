package org.bcit.comp2522.winter2023.midterm.questions;

public class Basic_02_Car {
  // Basic Question 02 (5 points, 3 TODOs)
  // Idea: tests your ability to create compositions of classes

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Basic_02_myClass. Name them something useful,
  // other than "myClass", that is just an example.

  // TODO 1: Create three new classes as declared here. You'll edit them
  // in a moment, start by simply creating the classes.
  Basic_02_Engine engine; // the thing that makes the car go, i.e., increase speed
  Basic_02_GasTank gasTank; // where the gas is stored
  Basic_02_Speedometer speedometer; // the thing that says how fast you're going

  public Basic_02_Car() {
    this.speedometer = new Basic_02_Speedometer(); // starts at 0 by default
    this.gasTank = new Basic_02_GasTank(100); // starts with 100 gas
    this.engine = new Basic_02_Engine(gasTank, speedometer);
  }

  // TODO 2: Create a function in Basic_02_Engine called "run" that:
  //  (1) increases Basic_02_Speedometer.speed by 1
  //  (2) decreases Basic_02_GasTank.gas by 1
  //  (3) Does the above IF and ONLY IF Basic_02_GasTank.gas > 0

  public void run() {
    engine.run();
  }

  public static void main(String[] args) {
    Basic_02_Car car = new Basic_02_Car();
    for (int i = 0; i < 99; i++) {
      car.run();
    }
    // car.speedometer.speed should be == 99;
    // car.gasTank.gas should be == 1;

    car.run();
    // car.speedometer.speed should be 100
    // car.gasTank.gas should be == 0;

    car.run();
    // car.speedometer.speed should be 100
    // car.gasTank.gas should be == 0;
  }

}
