package Farm;

import Animal.Animal;
import java.util.ArrayList;
import java.util.List;

public class Farm {
  List<Animal> animals = new ArrayList<Animal>();

  int freeSlots;

  public void breed() {
    if (freeSlots > 0) {
      animals.add(new Animal());
    }
  }

  public void slaughter() {
    Animal leastHungary = animals.get(0);
    for (Animal animal : animals) {
      if (animal.hunger < leastHungary.hunger) {
        leastHungary = animal;
      }
    }
    animals.remove(leastHungary);
  }
}
