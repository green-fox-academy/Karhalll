package FiveTreesClasses;

import java.awt.Color;

public class Tree {
  String type;
  Color leafColor;
  int age;
  char sex;

  Tree(String type, Color leafColor, int age, char sex) {
    this.type = type;
    this.leafColor = leafColor;
    this.age = age;
    this.sex = sex;
  }
}
