package Inheritance.GreenFoxOrganization;

public class Mentor extends Person {
  String level;

  Mentor() {
    level = "intermediate";
  }

  Mentor(String name, int age, String gender, String level) {
    super(name, age, gender);
    this.level = level;
  }

  @Override
  void introduce() {
    System.out.println(basicIntroduction() + " " + level + " mentor.");
  }

  @Override
  void getGoal() {
    System.out.println(getGoalBeginning() + "Educate brilliant junior software developers.");
  }
}
