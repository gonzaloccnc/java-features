package org.example.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NotMultithreading {
  public static void main(String[] args) {
    getPokemon();
    System.out.println("Waiting to response is completed");
  }

  public static void getPokemon() {
    String url = "https://pokeapi.co/api/v2/ability/?limit=10&offset=0";
    // Establece la conexión
    try {
      HttpURLConnection connection = null;
      connection = (HttpURLConnection) new URL(url).openConnection();
      connection.setRequestMethod("GET");
      InputStream inputStream = connection.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      // Procesa la respuesta
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }

      reader.close();
    } catch (IOException e) {
      e.printStackTrace(System.out);
    }
  }
}
