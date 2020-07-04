package Interfaces.CharSequence;

public class Shifter implements CharSequence {
  private String name;
  private String shifted;

  Shifter(String name, int shifts) {
    this.name = name;
    shifts = shifts % name.length();
    shifted = name.substring(shifts) + name.substring(0, shifts);
  }

  @Override
  public int length() {
    return shifted.length();
  }

  @Override
  public char charAt(int index) {
    return shifted.charAt(index);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return shifted.subSequence(start, end);
  }
}
