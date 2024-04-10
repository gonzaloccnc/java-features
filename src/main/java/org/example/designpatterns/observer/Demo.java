package org.example.designpatterns.observer;

public class Demo {
  public static void main(String[] args) {
    Editor editor = new Editor();
    editor.getEvents().subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
    editor.getEvents().subscribe("save", new EmailNotificationListener("admin@example.com"));

    try {
      editor.openFile("test.txt");
      editor.saveFile();
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
}
