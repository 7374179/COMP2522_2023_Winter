package org.bcit.comp2522.winter2023.midterm.questions;

public class Basic_05_Door {
  // Basic Question 05 (5 points, 4 TODOs)
  // Idea: tests your ability to create and use meaningful exceptions.

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Basic_05_myClass. Name them something useful,
  // other than "myClass", that is just an example.

  boolean locked;
  boolean open;

  public Basic_05_Door() {
    this.locked = false; // starts unlocked
    this.open = false; // starts closed
  }

  public void open() {
    // TODO 1: Create a new exception called Basic_05_LockedException
    // and throw it if this is called while locked == true
    // otherwise, set open = true
  }

  public void close() {
    // TODO 2: Use your new exception called Basic_05_LockedException
    // and throw it if this is called while locked == true
    // otherwise, set open = false
  }

  public void unlock() {
    this.locked = false;
  }

  public void lock() {
    // TODO 3: Create a new exception called Basic_05_OpenException
    // and throw it if this is called while open == true
    // otherwise, set lock = true
  }

  public void closeAndLock() {
    // TODO 4: Once you create and use your exceptions, surround each
    // with the appropriate try/catch block and handle any exceptions.
    this.close();
    this.lock();
  }

  public static void main(String[] args) {
    // Note that you may need to wrap the below in try/catch blocks
    Basic_05_Door door = new Basic_05_Door();
    door.lock(); // should be OK
    door.open(); // should throw an exception since it is closed
    door.unlock(); // should be OK
    door.open(); // should be OK
    door.lock(); // should throw an exception since it is open
    door.closeAndLock(); // should be OK
  }

}
