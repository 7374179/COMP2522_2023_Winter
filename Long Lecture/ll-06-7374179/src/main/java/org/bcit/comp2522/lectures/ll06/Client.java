package org.bcit.comp2522.lectures.ll06;

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
  int id;
  int message_number;

  public Client(int id) {
    this.id = id;
    this.message_number = 0;
  }

  public void run() {
    // get the localhost IP address, if server is running on some other IP, you need to use that
    InetAddress host = null;
    try {
      System.out.println("Attempting to get address of host...");
      host = InetAddress.getLocalHost();
    } catch (UnknownHostException e) {
      System.err.format("Can't get address of host, exiting client %d.", id);
      return;
    }

    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    while(true) {
      // establish socket connection to server
      try {
        System.out.println("Attempting to connect to server...");
        socket = new Socket(host.getHostName(), 9876);
        System.out.println("Attempting to create object output stream...");
        oos = new ObjectOutputStream(socket.getOutputStream());
      } catch (IOException e) {
        System.err.format("Can't create object streams, exiting client %d.", id);
        return;
      }
      // write to socket using ObjectOutputStream
      try {
        System.out.println("Attempting to send request to Socket Server...");
        oos.writeObject(String.format("Client %d request: %d", id, message_number));
        message_number++;
      } catch (IOException e) {
        System.err.format("Can't write to object stream, exiting client %d.", id);
        return;
      }

      // read the server response message
      String message = null;
      try {
        System.out.println("Attempting to create object input stream...");
        ois = new ObjectInputStream(socket.getInputStream());
        System.out.println("Attempting to read from object stream...");
        message = (String) ois.readObject();
        System.out.println("Message from server: " + message);
      } catch (IOException e) {
        System.err.format("Can't read from object stream, exiting client %d.", id);
        return;
      } catch (ClassNotFoundException e) {
        System.err.format("Can't convert to string from object stream, exiting client %d.", id);
        return;
      }

      // close resources
      try {
        System.out.println("Attempting to close object streams...");
        ois.close();
        oos.close();
      } catch (IOException e) {
        System.err.format("Can't close object stream, exiting client %d.", id);
        return;
      }

      try {
        System.out.format("Tick: %d\n", System.nanoTime());
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.err.format("Can't sleep thread, exiting client %d.", id);
        return;
      }
    }
  }

  public static void main(String[] args){
    Thread thread0 = new Thread(){
      public void run(){
        Client c0 = new Client(0);
        c0.run();
        System.out.println("Thread Running for Client 0");
      }
    };
    thread0.start();

    Thread thread1 = new Thread(){
      public void run(){
        Client c1 = new Client(1);
        c1.run();
        System.out.println("Thread Running for Client 1");
      }
    };
    thread1.start();

    Thread thread2 = new Thread(){
      public void run(){
        Client c2 = new Client(2);
        c2.run();
        System.out.println("Thread Running for Client 2");
      }
    };
    thread2.start();

  }


}