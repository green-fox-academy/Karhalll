package Inheritance.GreenFoxOrganization;

public class Sponsor extends Person{
  String company;
  int hiredStudents;

  Sponsor() {
    company = "Google";
    hiredStudents = 0;
  }

  Sponsor(String name, int age, String gender, String company) {
    super(name, age, gender);
    this.company = company;

    hiredStudents = 0;
  }

  void hire() {
    hiredStudents++;
  }

  @Override
  void introduce() {
    System.out.println(basicIntroduction() + " who represents " + company + " and hired "
        + hiredStudents + " students so far."
    );
  }

  @Override
  void getGoal() {
    System.out.println(getGoalBeginning() + "Hire brilliant junior software developers.");
  }
}
