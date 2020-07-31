package Counter;

public class Counter {
  int field;

  private int initialValue = 0;

  public Counter() {
    reset();
  }

  public Counter(int field) {
    initialValue = field;
    reset();
  }

  public void add(int number) {
    field += number;
  }

  public void add() {
    field++;
  }

  public int get() {
    return field;
  }

  public void reset() {
    field = initialValue;
  }
}
