package org.bcit.comp2522.lectures.ll06;

import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;

public class MyHttpServer {
  public static void main(String[] args) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
    server.createContext("/", new MyHttpHandler());
    server.start();
  }
}
