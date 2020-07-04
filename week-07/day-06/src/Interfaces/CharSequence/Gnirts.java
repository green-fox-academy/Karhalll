package Interfaces.CharSequence;

public class Gnirts implements CharSequence {
  private String name;

  private String reverse;

  Gnirts (String name) {
    this.name = name;
    reverse = "";
    for(int i = name.length() - 1; i >= 0; i--)
    {
      reverse = reverse + name.charAt(i);
    }
  }

  @Override
  public int length() {
    return reverse.length();
  }

  @Override
  public char charAt(int index) {
    return reverse.charAt(index);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return reverse.subSequence(start, end);
  }
}
