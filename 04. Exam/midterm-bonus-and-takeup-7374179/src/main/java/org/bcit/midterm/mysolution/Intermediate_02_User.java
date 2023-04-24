package src.main.java.org.bcit.midterm.mysolution;

import java.util.ArrayList;

public class Intermediate_02_User {
  Intermediate_02_User user1;
  Intermediate_02_User user2;
  public Intermediate_02_User(){}
  public Intermediate_02_Blog blog;
  ArrayList<Intermediate_02_Post> posts;

  public Intermediate_02_Comment addComment(Intermediate_01_Post a, String b){
    return null;
  }
  public Intermediate_02_Post addPost(String a){
    return blog.addPost(this, a);
  }

//  return blog.addPost(this, b);

}
