package org.example.functional;

import java.util.List;
import java.util.function.*;

public class FunctionalJava {
  public static void main(String[] args) {
    var isMyName = whatIsMyName.apply("Gonzalo");
    var gonzalo = saveUser.apply("Gonzalo", 21);

    System.out.println(isMyName);
    System.out.println(gonzalo);
    sayHello.accept("Gonzalo");
    sayWhatIsTheUser.accept("Gonzalo", 21);
    System.out.println(greaterThan.test("easy"));
    System.out.println(greaterThan.test("strongpassword"));
    var isValidPassword = greaterThan.and(startsWith123);
    System.out.println(isValidPassword.test("125strongpassword"));
    System.out.println(isValidPassword.test("123easy"));
    System.out.println(isValidPassword.test("123strongpassword"));
    System.out.println("are equals?, " + whatsDoIt.test("hello", "man"));
    System.out.println(getSecretToken.get());
    var strings = List.of("123Hola", "213Hola", "123Hola");
    var strings2 = List.of("123Hola", "123Hola", "123Hola");
    var allMatch = strings.stream().allMatch(startsWith123);
    var allMatch2 = strings2.stream().allMatch(startsWith123);
    var someMatch = strings.stream().anyMatch(startsWith123);
    System.out.println("All match? " + allMatch);
    System.out.println("All match2? " + allMatch2);
    System.out.println("Someone match? " + someMatch);
    helloWithCallback("Gonzalo", "Manco", null);
    helloWithCallback("Gonzalo", null, System.out::println);
    strings2.forEach(System.out::println);
    System.out.println(reduceTo.apply("hola ", "gonzalo"));
    var accumulator = strings.stream().reduce(reduceTo);
    System.out.println("Accumulator: " + accumulator);
    System.out.println("Exist secret token?, " + existSecretToken.getAsBoolean());
  }
  static Function<String, String> whatIsMyName = name -> name;
  static BiFunction<String, Integer, User> saveUser = User::new;
  static Consumer<String> sayHello = System.out::println;
  static BiConsumer<String, Integer> sayWhatIsTheUser = (name, age) -> System.out.println(new User(name, age));
  static Predicate<String> greaterThan = password -> password.length() >= 8;
  static Predicate<String> startsWith123 = password -> password.startsWith("123");
  static BiPredicate<String, String> whatsDoIt = String::equals;
  static Supplier<String> getSecretToken = () -> "YOURSTRONGANDHASHSECRETTOKEN";
  static void helloWithCallback(String firstname, String lastname, Consumer<String> callback) {
    if(lastname != null) {
      System.out.println(lastname);
      return;
    }
    callback.accept(firstname);
  }
  static BinaryOperator<String> reduceTo = (a, b) -> {
    System.out.println("Inside value is: " + a + " and other value is: " + b);
    return a + b;
  };
  static BooleanSupplier existSecretToken = () -> {
    var SECRET = getSecretToken.get();
    return !SECRET.isEmpty();
  };
  static class User {
    private final String name;
    private final int age;
    public User(String name, Integer age) {
      this.name = name;
      this.age = age;
    }
    public String getName() {
      return name;
    }
    public int getAge() {
      return age;
    }
    public String toString() {
      return "name: " + name + ", age: " + age;
    }
  }

}
