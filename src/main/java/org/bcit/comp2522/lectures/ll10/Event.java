package org.bcit.comp2522.lectures.ll10;

public class Event {
  EventListener eventListener;

  public Event(EventListener eventListener) {
    this.eventListener = eventListener;
  }

  public void trigger() {
    eventListener.onTrigger();
  }
}
