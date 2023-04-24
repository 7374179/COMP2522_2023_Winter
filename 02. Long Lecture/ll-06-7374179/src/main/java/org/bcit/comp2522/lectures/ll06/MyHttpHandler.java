package org.bcit.comp2522.lectures.ll06;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class MyHttpHandler implements HttpHandler {
  public void handle(HttpExchange t) throws IOException {
    URI uri = t.getRequestURI();
    String response = String.format("Hello, %s World!\n", uri.getPath());

    // Routing example
    if (uri.getPath().strip().equals("/secret".strip())) {
      response = String.format("This is a secret!!!!");
    }

    Headers h = t.getResponseHeaders();
    h.set("Content-Type","text/html");
    t.sendResponseHeaders(200, response.length());
    OutputStream os = t.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }
}
