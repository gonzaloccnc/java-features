package org.example.poo;

import java.time.LocalDate;

public class Main {

  public static void main(String[] args) {
    // Inheritance and Encapsulation
    Person person = new Person("Gonzalo", 21, "Manco Garcia", LocalDate.of(2002, 10, 3));
    Employee employee = new Employee("Manuel", 23, "Luap Molit", LocalDate.of(2000, 3, 20), 2000.0F, "Google");

    System.out.println(person);
    System.out.println(employee);

    // Abstraction and Interfaces and Polymorphism

    // method polymorphism
    Animal animal = new Animal();
    Animal dog = new Dog();
    animal.makeSound();
    dog.makeSound();

    // abstract class
    Vehicle car = new Car();
    car.run();
    car.stop();

    // interface
    IVehicle bicycle = new Bicycle();
    bicycle.run();
    bicycle.stop();

  }
}
