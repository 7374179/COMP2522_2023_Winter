package org.bcit.comp2522.labs.lab10;

public class CallbackExample {
  public static void main(String[] args) {
    InputEvent input = new InputEvent();
    Boolean run = true;
    while(run) {
      run = input.TriggerInputEvent();
    }
  }
}