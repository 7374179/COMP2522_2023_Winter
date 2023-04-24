package org.bcit.comp2522.labs.lab10;

import java.util.Scanner;

public class InputEvent {
  private final EventListener eventListener;

  public InputEvent() {
    this.eventListener = new DownloadDataEventListener();
  }

  public Boolean TriggerInputEvent() {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter command");
    String first_name = myObj.nextLine();
    if (first_name.strip().length() > 0) {
      System.out.println(eventListener.onTrigger(first_name));
    } else {
      System.out.println(eventListener.onTrigger());
    }

    if (first_name == "exit") {
      return false;
    }
    return true;
  }

}
