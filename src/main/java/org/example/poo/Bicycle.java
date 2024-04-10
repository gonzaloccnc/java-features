package org.example.poo;

public class Bicycle implements IVehicle {
  public Bicycle() {
  }

  @Override
  public void run() {
    System.out.println("Running the bicycle");
  }

  @Override
  public void stop() {
    System.out.println("Stopping the bicycle");
  }

}
