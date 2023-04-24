package org.bcit.comp2522.lectures.ll06;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * This class implements java Socket server
 * @author pankaj
 *
 */
public class Server {

  // static ServerSocket variable
  private static ServerSocket server;

  // socket server port on which it will listen
  private static int port = 9876;

  public static void main(String args[]) {
    // create the socket server object
    try {
      server = new ServerSocket(port);
    } catch (IOException e) {
      System.err.println("Can't connect to socket.");
    }
    Random random = new Random();

    // keep listens indefinitely until receives 'exit' call or program terminates
    while(true){
      // simulate a high number of connections and latency
      try {
        Thread.sleep(random.nextInt(5000));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      System.out.println("Waiting for the client request");

      // creating socket and waiting for client connection
      Socket socket = null;
      try {
        socket = server.accept();
      } catch (IOException e) {
        System.err.println("Can't connect to client.");
        continue;
      }

      // read from socket to ObjectInputStream object
      ObjectInputStream ois = null;
      try {
        ois = new ObjectInputStream(socket.getInputStream());
      } catch (IOException e) {
        System.err.println("Can't connect to input stream.");
        continue;
      }

      // convert ObjectInputStream object to String
      String message = null;
      try {
        message = (String) ois.readObject();
      } catch (IOException e) {
        System.err.println("Can't read from input stream.");
      } catch (ClassNotFoundException e) {
        System.err.println("Can't cast message to string.");
      } catch (NullPointerException e) {
        System.err.println("Client disengaged in the middle of sending.");
        continue;
      }

      System.out.println("Message Received: " + message);

      // create ObjectOutputStream object
      ObjectOutputStream oos = null;
      try {
        oos = new ObjectOutputStream(socket.getOutputStream());
      } catch (IOException e) {
        System.err.println("Can't connect to output stream.");
      }

      // write object to Socket
      try {
        oos.writeObject("Hi "+message);
      } catch (IOException e) {
        System.err.println("Can't write message to output stream.");
      }

      try {
        // close resources
        ois.close();
        oos.close();
        socket.close();
      } catch (IOException e) {
        System.err.println("Can't close resources.");
      }

      // terminate the server if client sends exit request
      if(message.equalsIgnoreCase("exit")) break;
    }
    System.out.println("Shutting down Socket server!!");

    // close the ServerSocket object
    try {
      server.close();
    } catch (IOException e) {
      System.err.println("Server closed poorly.");
    }
  }

}