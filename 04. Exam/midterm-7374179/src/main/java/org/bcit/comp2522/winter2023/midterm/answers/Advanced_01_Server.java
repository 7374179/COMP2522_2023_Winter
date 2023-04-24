package org.bcit.comp2522.winter2023.midterm.answers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Advanced_01_Server {
  private static ServerSocket ss;
  private static int port = 5678;

  public static void main(String args[]) throws IOException, InterruptedException, ClassNotFoundException {
    ss = new ServerSocket(port);
    Random random = new Random();

    while(true){
      Thread.sleep(random.nextInt(1234));
      System.out.println("not completed");
      Socket socket = ss.accept();
      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

      String message = (String) ois.readObject();
      System.out.println("Message: " + message);
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

      oos.writeObject("Nice to meet you "+message);
      ois.close();
      oos.close();
      socket.close();

      if(message.equalsIgnoreCase("end")) break;
    }

  }

}
