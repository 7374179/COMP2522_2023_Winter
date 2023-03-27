package org.bcit.comp2522.lectures.sl13;
import org.bson.Document;
import java.io.*;
import java.net.Socket;
import java.util.Random;

public class ClientHandler implements Runnable {
  private Socket clientSocket;

  public ClientHandler(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  @Override
  public void run() {
    try {
      // read the message from the client
      // TODO: read message from client

      // parse the message
      // TODO: Parse the BSON document that was sent to you

      System.out.format("Received message from client %s: %s\n", uid, body);

      // Simulate some hard work on the server side
      Thread.sleep(new Random().nextInt(2000));

      // send a response
      // TODO: Create a BSON document that a client will parse

      // TODO: Send response to client

      // close resources
      dataInputStream.close();
      dataOutputStream.close();
      clientSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
