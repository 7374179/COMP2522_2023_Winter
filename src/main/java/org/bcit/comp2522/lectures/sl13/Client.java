package org.bcit.comp2522.lectures.sl13;

import org.bson.Document;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Random;

public class Client {
  String serverAddress;
  int serverPort;
  int uid;

  public Client(String serverAddress, int serverPort) {
    this.serverAddress = serverAddress;
    this.serverPort = serverPort;
    this.uid = new Random().nextInt(1000000);
  }

  public void run() {
    try {
      // Connect to the server
      System.out.println("Connecting to server...");
      Socket socket = new Socket();
      socket.connect(new InetSocketAddress(serverAddress, serverPort), 5000);

      // construct a message
      // TODO: create a BSON document that you can send as a message

      // Send a message
      OutputStream output = socket.getOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(output);
      dataOutputStream.writeUTF(message.toJson());

      // wait for a response
      InputStream input = socket.getInputStream();
      DataInputStream dataInputStream = new DataInputStream(input);
      String response = dataInputStream.readUTF();

      System.out.format("Server Response: %s\n", Document.parse(response).get("body"));

      // close resources
      dataInputStream.close();
      dataOutputStream.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Client client = new Client("localhost", 8000);
    client.run();
  }
}
