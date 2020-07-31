package Inheritance.GreenFoxOrganization;

public class Person {
  String name;
  int age;
  String gender;

  Person() {
    name = "Jane Doe";
    age = 30;
    gender = "female";
  }

  Person(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  void introduce() {
    System.out.println(basicIntroduction() + ".");
  }

  void getGoal() {
    System.out.println(getGoalBeginning() + "Live for the moment!");
  }

  String getGoalBeginning() {
    return "My goal is: ";
  }

  String basicIntroduction() {
    return "Hi, I'm " + name + ", a " + age + " years old " + gender;
  }
}
