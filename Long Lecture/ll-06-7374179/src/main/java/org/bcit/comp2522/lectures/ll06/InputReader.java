package org.bcit.comp2522.lectures.ll06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
  public static void main(String[] args) {

    // Enter data using BufferReader
    BufferedReader reader = new BufferedReader(
      new InputStreamReader(System.in));
    String input = "";

    while(!input.strip().equals("exit".strip())) {
      System.out.format("type message: ");
      // Reading data using readLine
      try {
        input = reader.readLine();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      // Printing the read line
      System.out.format("receive: %s\n", input);
    }
    System.out.format("Exiting...Goodbye!\n");
  }
}
