package org.bcit.comp2522.labs.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
public class DownloadDataEventListener implements EventListener {
  @Override
  public String onTrigger(String name) {
    Random random = new Random();
    try {
      Thread.sleep(random.nextInt(2000));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    String data = stream("https://reqres.in/api/users?page=2");
    JSONObject json = new JSONObject(data);
    JSONArray users = json.getJSONArray("data");
    Object ret = users;
    for (Object user : users) {
      Object result = null;
      JSONObject u = (JSONObject) user;
      try {
        result = u.get("first_name");
      } catch (Exception e) {
        System.out.println("No such key.");
      }
      if (result != null) {
        if (result.toString().strip().equals(name.strip())) {
          ret = user;
        }
      }
    }
    return ret.toString();
  }

  @Override
  public String onTrigger() {
    System.out.println(stream("https://reqres.in/api/users?page=2"));
    return null;
  }

  public static String stream(String urlstr) {
    URL url = null;
    try {
      url = new URL(urlstr);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
    try (InputStream input = url.openStream()) {
      InputStreamReader isr = new InputStreamReader(input);
      BufferedReader reader = new BufferedReader(isr);
      StringBuilder json = new StringBuilder();
      int c;
      while ((c = reader.read()) != -1) {
        json.append((char) c);
      }
      return json.toString();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    DownloadDataEventListener dd = new DownloadDataEventListener();
    dd.onTrigger();
  }
}
