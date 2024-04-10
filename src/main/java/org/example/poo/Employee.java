package org.example.poo;

import java.time.LocalDate;

public class Employee extends Person {
  private Float salary;
  private String enterprise;

  public Employee(String name, Integer age, String surnames, LocalDate birthdate, Float salary, String enterprise) {
    super(name, age, surnames, birthdate);
    this.salary = salary;
    this.enterprise = enterprise;
  }

  public Float getSalary() {
    return salary;
  }

  public void setSalary(Float salary) {
    this.salary = salary;
  }

  public String getEnterprise() {
    return enterprise;
  }

  public void setEnterprise(String enterprise) {
    this.enterprise = enterprise;
  }

  @Override
  public String toString() {
    return String.format("%s, salary: %s, enterprise: %s", super.toString(), salary, enterprise);
  }
}
