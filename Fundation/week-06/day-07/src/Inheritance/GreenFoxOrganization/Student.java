package Inheritance.GreenFoxOrganization;

public class Student extends Person {
  String previousOrganization;
  int skippedDays;

  Student() {
    previousOrganization = "The School of Live";
    skippedDays = 0;
  }

  Student(String name, int age, String gender, String previousOrganization) {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;

    skippedDays = 0;
  }

  void skipDays(int numberOfDays) {
    skippedDays += numberOfDays;
  }

  @Override
  void introduce() {
    System.out.println(basicIntroduction() + " from " + previousOrganization + " who skipped "
        + skippedDays + " days from the course already."
    );
  }

  @Override
  void getGoal() {
    System.out.println(getGoalBeginning() + "Be a junior software developer.");
  }
}
