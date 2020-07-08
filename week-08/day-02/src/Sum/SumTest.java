package Sum;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SumTest {
  Sum sum = new Sum();
  ArrayList<Integer> numbers = new ArrayList<>();

  @Test
  void sumList() {
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);

    assertEquals(15, sum.sum(numbers));
  }

  @Test
  void sumEmptyList() {
    assertEquals(0, sum.sum(numbers));
  }

  @Test
  void sumOneElementList() {
    numbers.add(5);

    assertEquals(5, sum.sum(numbers));
  }

  @Test
  void sumNullList() {
    ArrayList<Integer> nullList = null;

    assertEquals(0, sum.sum(nullList));
  }
}