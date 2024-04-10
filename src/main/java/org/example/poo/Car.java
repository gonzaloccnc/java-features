package org.example.poo;

public class Car extends Vehicle {
  public Car() {
  }

  @Override
  public void run() {
    System.out.println("Running the car");
  }

  @Override
  public void stop() {
    System.out.println("Stopping the car");
  }
}
