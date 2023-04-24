package org.bcit.comp2522.lectures.ll10;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;




public class DataDownloader implements EventListener {
  volatile boolean lock = false;

  public class MyThread extends Thread {
    @Override
    public void run() {
      if (!lock) {
        lock = true;
        callback(fetch());
        lock = false;
      }
    }
  }

  @Override
  public void onTrigger() {
//    new Thread( () -> callback(fetch())).start();
    Thread thread = new Thread(() -> callback(fetch()));
    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
//     callback(fetch());
  }

  public JSONObject fetch() {
    Random random = new Random();

    // This is simulating a slow internet connection, so leave it in.
    try {
      Thread.sleep(random.nextInt(2000));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    // end simulation of slow internet

    String data = stream("https://reqres.in/api/users");
    JSONObject response = new JSONObject(data);
    return response;
  }

  /**
   * Callback for our main processing function.
   * Finds a random image URL and saves it to file.
   *
   * @param json
   */
  public void callback(JSONObject json) {
    JSONArray users = (JSONArray) json.get("data");

    // get a random image
    Random random = new Random();
    try {
      int index = random.nextInt(users.length());
      JSONObject user = (JSONObject) users.get(index);
      String imageURL = (String) user.get("avatar");
      saveImage(imageURL, "image.jpg");
    } catch (Exception e) {
      System.out.println("Some error, btw 2522 students never do this, this is just an example!!!");
    }
  }

  /**
   * Fetch and save image from URL.
   *
   * @param imageUrl
   * @param destinationFile
   * @throws IOException
   */
  public static void saveImage(String imageUrl, String destinationFile) throws IOException {
    URL url = new URL(imageUrl);
    InputStream is = url.openStream();
    OutputStream os = new FileOutputStream(destinationFile);

    byte[] b = new byte[2048];
    int length;

    while ((length = is.read(b)) != -1) {
      os.write(b, 0, length);
    }
    is.close();
    os.close();
  }

  // Get a stream of string
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
}
