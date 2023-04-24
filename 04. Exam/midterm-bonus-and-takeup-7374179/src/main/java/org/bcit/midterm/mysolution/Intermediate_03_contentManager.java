package src.main.java.org.bcit.midterm.mysolution;

import java.util.ArrayList;

public class Intermediate_03_contentManager {
    ArrayList<Intermediate_02_User> users;
    ArrayList<Intermediate_02_Blog> blogs;
    public static void main(String[] args) {
        Intermediate_02_User u1 = new Intermediate_02_User();
        Intermediate_02_User u2 = new Intermediate_02_User();
        u1.addPost("I am writing a blog post.");
    }
}
