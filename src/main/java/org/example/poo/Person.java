package org.example.poo;

import java.time.LocalDate;

public class Person {

  private String name;
  private Integer age;
  private String surnames;
  private LocalDate birthdate;

  public Person(String name, Integer age, String surnames, LocalDate birthdate) {
    this.name = name;
    this.age = age;
    this.surnames = surnames;
    this.birthdate = birthdate;
  }

  @Override
  public String toString() {
    return String.format(
        "name: %s, age: %d, surnames: %s, birthdate: %s",
        name,
        age,
        surnames,
        birthdate
    );
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getSurnames() {
    return surnames;
  }

  public void setSurnames(String surnames) {
    this.surnames = surnames;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }
}
