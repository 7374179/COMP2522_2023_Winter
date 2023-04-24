package org.bcit.comp2522.lectures.ll12;

public class SharedResource {

    synchronized void print(String id) {
      System.out.format("Thread %s called print!\n", id);
    }

}
