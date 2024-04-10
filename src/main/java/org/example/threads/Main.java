package org.example.threads;

import java.util.List;

public class Main {
    public static void main(String[] args) {
      List<Integer> integers = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

      // we need call 2 APIs and both can be called at the same time
      // because if we call the API synchronous we would wait 8 second that task is completed
      Thread thread = new Thread(() -> {
        // this call an api and wait 5s
        try {
          Thread.sleep(5000);
        } catch (InterruptedException ex) {
          System.out.println(ex.getMessage());
        }
        System.out.println("RESPONSE STATUS OK API 1");
      });

      Thread thread2 = new Thread(() -> {
        // this call other api and wait 3s
        try {
          Thread.sleep(3000);
        } catch (InterruptedException ex) {
          System.out.println(ex.getMessage());
        }
        System.out.println("RESPONSE STATUS OK API 2");
      });

      Thread threadPoke = new Thread(NotMultithreading::getPokemon);
      thread.start();
      thread2.start();
      threadPoke.start();

      try {
        threadPoke.join();
      } catch (InterruptedException e) {
        e.printStackTrace(System.out);
      }

      // here we can do others things
      integers.stream().parallel().forEach(System.out::println);

      System.out.println("Hello ");
    }
}
