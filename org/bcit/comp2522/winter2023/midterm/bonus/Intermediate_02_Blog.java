package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.ArrayList;

public class Intermediate_02_Blog {
  public Intermediate_02_Blog(){}
  public ArrayList<Intermediate_02_Post> posts;
  Intermediate_02_RSSFeed rssFeed;
  Intermediate_02_Post post;
//  public Intermediate_02_Comment addComment(Intermediate_02_Post, Intermediate_01_ClassDiagram_User, String){}
//  public Intermediate_02_Post addPost(Intermediate_01_ClassDiagram_User a, String b) {}
//  public Boolean NotifyRSS(Intermediate_02_Feedable a){}
//
//  post.post();
//  rssFeed.notify();

//  ArrayList<Intermediate_02_Post> posts;
  Intermediate_02_Post addPost(Intermediate_02_User user, String str) {
    Intermediate_02_Post post = new Intermediate_02_Post();
    Intermediate_02_RSSFeed rssFeed = new Intermediate_02_RSSFeed();
    rssFeed.notify(post);
    return null;
  }
}
