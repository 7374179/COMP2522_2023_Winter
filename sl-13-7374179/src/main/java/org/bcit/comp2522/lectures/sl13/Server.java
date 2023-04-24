package org.bcit.comp2522.lectures.sl13;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

  public static void main(String[] args) throws IOException {
    int port; // TODO: initialize
    int poolSize; // TODO: initialize
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.format("Server started on port %d.\n", port);
    // TODO: create an executor server to run your client handler
    while (true) {
      // TODO: Accept the socket connection
      System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());
      // TODO: run the client handler
    }
  }
}