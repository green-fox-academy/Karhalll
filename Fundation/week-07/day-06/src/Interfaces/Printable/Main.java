package Interfaces.Printable;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Domino> dominoes = new ArrayList<>();
    List<Todo> todos = new ArrayList<>();

    dominoes.add(new Domino(4, 8));
    dominoes.add(new Domino(3, 6));
    dominoes.add(new Domino(9, 2));

    todos.add(new Todo("Buy Milk", "low", true));
    todos.add(new Todo("Sell House", "high", false));
    todos.add(new Todo("Enjoy Life", "high", false));

    for (Domino d : dominoes) {
      d.printAllFields();
    }

    for (Todo t : todos) {
      t.printAllFields();
    }


    List<Object> objects = new ArrayList<>();
    objects.add(new Domino(4, 8));
    objects.add(new Domino(3, 6));
    objects.add(new Domino(9, 2));
    objects.add(new Todo("Buy Milk", "low", true));
    objects.add(new Todo("Sell House", "high", false));
    objects.add(new Todo("Enjoy Life", "high", false));

    for (Object object : objects) {
      if (object instanceof Printable) {
        ((Printable) object).printAllFields();
      }
    }
  }
}
