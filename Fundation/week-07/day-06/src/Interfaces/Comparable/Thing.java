package Interfaces.Comparable;

public class Thing implements Comparable<Thing> {
  private String name;
  private boolean completed;

  public Thing(String name) {
    this.name = name;
  }

  public void complete() {
    this.completed = true;
  }

  @Override
  public String toString() {
    return (completed ? "[x] " : "[ ] ") + name;
  }

  @Override
  public int compareTo(Thing other) {
    int result = Boolean.compare(this.completed, other.completed);
    if (result == 0) {
      result = this.name.compareTo(other.name);
    }
    return result;
  }
}
