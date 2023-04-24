package org.bcit.comp2522.winter2023.midterm.questions;

import java.util.AbstractList;
import java.util.List;

public class Basic_07_GitHubManager {
  // Basic Question 07 (5 points, 3 TODOs)
  // Idea: tests your ability to trace code

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Basic_07_myClass. Name them something useful,
  // other than "myClass", that is just an example.

  public static void main(String[] args) {
    Basic_07_GitHubManager gitHubManager = new Basic_07_GitHubManager();
    Remote remote = new Remote("http://github.com/fake");
    Local local = new Local(remote);
    File file = new File();
    file.edit("New text added...");
    // TODO 1: Trace the code from the next line and write down in a comment
    // directly below this TODO the exact sequence of method calls that local.add(file) and
    // local.push() initiates in the correct order. Include only the method calls.
    local.add(file);
    local.push();
  }
  private static class Remote {
    String url;
    List<File> files;
    public Remote (String url) {
      this.url = url;
    }
    public void push(File f) {
      files.add(f);
    }
  }

  private static class Local {
    private List<File> changed;
    private Remote remote;

    public Local(Remote remote) {
      this.remote = remote;
    }

    public void add(File f) {
      if (f.getEdited()) {
        changed.add(f);
      }
    };

    public void push() {
      for (File f : changed) {
        remote.push(f);
        f.setEdited(false);
      }
    }
  }

  private static class File {
    private boolean edited;
    String text;

    public void edit(String text) {
      this.text = text;
      edited = true;
    }
    public void setEdited(boolean edited) {
      this.edited = edited;
    }
    public boolean getEdited() {
      return this.edited;
    }
  }
}
