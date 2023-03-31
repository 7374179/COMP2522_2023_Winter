package org.bcit.comp2522.lectures.ll13;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;

import java.awt.*;

import static com.mongodb.client.model.Filters.eq;

public class MongoDB {
  MongoDatabase database;

  public MongoDB(String username, String password) {
    ConnectionString connectionString = new ConnectionString(String.format("mongodb+srv://%s:%s@2522.czkkwuu.mongodb.net/?retryWrites=true&w=majority", username, password));
    MongoClientSettings settings = MongoClientSettings.builder()
      .applyConnectionString(connectionString)
      .serverApi(ServerApi.builder()
        .version(ServerApiVersion.V1)
        .build())
      .build();
    MongoClient mongoClient = MongoClients.create(settings);
    database = mongoClient.getDatabase("game");
    try {
      database.createCollection("players");
    } catch (Exception e) {
      System.out.println("Collection already in database.");
    }
  }
  public void put(GameState gs) {
    String hex = String.format("#%02x%02x%02x", gs.me.c.getRed(), gs.me.c.getGreen(), gs.me.c.getBlue());
    UpdateOptions options = new UpdateOptions().upsert(true);
    Document player = new Document();
    player.append("x", gs.me.x);
    player.append("y", gs.me.y);
    player.append("color", hex);
    player.append("name", gs.me.name);
    database.getCollection("players").updateOne(
      eq("name", gs.me.name),  new Document("$set", player), options
    );
  };

  public GameState get(GameState gs) {
    GameState newGs = new GameState(gs.me);
    FindIterable<Document> res = database.getCollection("players").find();
    res.forEach((d) -> {
      if (!d.get("name").toString().equals(gs.me.name)) {
        Player p = new Player(
          Float.parseFloat(d.get("x").toString()),
          Float.parseFloat(d.get("y").toString()),
          Color.decode(d.get("color").toString()),
          d.get("name").toString()
        );
        newGs.players.add(p);
      }
    });
    return newGs;
  }

}