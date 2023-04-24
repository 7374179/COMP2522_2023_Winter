package org.bcit.comp2522.lecture.sl06;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This class implements java socket client
 * @author pankaj
 *
 */
public class Client {

  public static void main(String[] args) {

//  public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
    // get the localhost IP address, if server is running on some other IP, you need to use that
    InetAddress host = null;
    try {
      host = InetAddress.getLocalHost();
    } catch (Exception e) {
//      throw new RuntimeException(e);
      System.err.format("Can't find address of local host.");
    }

    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    int i = 0;
    while(true) {

      // establish socket connection to server
      try {
        socket = new Socket(host.getHostName(), 9876);
      } catch (Exception e) {
//        throw new RuntimeException(e);
        System.err.format("Can't connect oto host socket.");
      }


      // write to socket using ObjectOutputStream
      try {
        oos = new ObjectOutputStream(socket.getOutputStream());
      } catch (Exception e) {
//        throw new RuntimeException(e);
        System.err.format("can't write to socket output on client message. ");
      }
//      System.out.println("Sending request to Socket Server");
//      oos = new ObjectOutputStream(socket.getOutputStream());
//      System.out.println("Sending request to Socket Server");

      if (i == 1000) {
        try {
          oos.writeObject("exit");
        } catch (Exception e) {
//          throw new RuntimeException(e);
          System.err.format("can't write te message");
        }
        break;
      }

      try {
        oos.writeObject("Request: " + i);
//      } catch (IOException e) {
      } catch (Exception e) {

//        throw new RuntimeException(e);
        System.err.format("can't write to socket output on client message");
      }
      i++;

      // read the server response message
      try {
        ois = new ObjectInputStream(socket.getInputStream());
      } catch (Exception e) {
//        throw new RuntimeException(e);
        System.err.format("can't getInstance");
      }
      String message = null;
      try {
        message = (String) ois.readObject();
      } catch (Exception e) {
//        throw new RuntimeException(e);
        System.err.format("can't read message from server");
      }
//      catch (Exception e) {
//        System.err.format("Can't cast received message to String");
//        throw new RuntimeException(e);
//        System.err.format("can't wait");
//      }
      System.out.println("Message: " + message);

      // close resources
      try {
        ois.close();
        oos.close();
      } catch (Exception e) {
//        throw new RuntimeException(e);
        System.err.format("Can't close stream resources.");
      }

      System.out.format("Tick: %d\n", System.nanoTime());
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
//        throw new RuntimeException(e);
        System.err.format("can't sleep");
      }
    }
  }
}