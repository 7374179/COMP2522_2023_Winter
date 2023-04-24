package src.main.java.org.bcit.midterm.mysolution;

public class Intermediate_03_Blog {
  public Intermediate_03_Blog(){}
  Intermediate_02_RSSFeed rssFeed;
  Intermediate_02_Post post;
  public Intermediate_02_Comment comment;
  public Intermediate_02_Post addPost(Intermediate_02_User user, String str) {
    Intermediate_02_Post post = new Intermediate_02_Post();
    Intermediate_02_RSSFeed rssFeed = new Intermediate_02_RSSFeed();
    rssFeed.notify(post);
    return null;
  }
  public void Blog(){}
  public void addPost(){}
  public void addComment(){}
}
