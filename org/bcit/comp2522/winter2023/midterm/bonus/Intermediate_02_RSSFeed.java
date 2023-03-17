package org.bcit.comp2522.winter2023.midterm.bonus;

public class Intermediate_02_RSSFeed {
  public Intermediate_02_RSSFeed(){}
  Intermediate_02_Post post;
  public Boolean notify(Intermediate_02_Feedable a){
    a.getContent();
    return true;
  }

}
