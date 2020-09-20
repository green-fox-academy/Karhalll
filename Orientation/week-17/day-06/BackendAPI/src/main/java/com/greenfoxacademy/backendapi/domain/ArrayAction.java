package com.greenfoxacademy.backendapi.domain;

import java.util.Arrays;

public class ArrayAction {

  private String what;
  private Integer[] numbers;

  public ArrayAction() {
  }

  public String getWhat() {
    return what;
  }

  public void setWhat(String what) {
    this.what = what;
  }

  public Integer[] getNumbers() {
    return numbers;
  }

  public void setNumbers(Integer[] numbers) {
    this.numbers = numbers;
  }

  @Override
  public String toString() {
    if (what == null || numbers == null) {
      return "incomplete data provided";
    } else {

      StringBuilder output = new StringBuilder("{"
          + "what=" + what
          + ";numbers=[");

      for (Integer i : numbers){
        output.append(i).append(",");
      }
      output.deleteCharAt(output.length() - 1);
      output.append("]}");
      return output.toString();
    }
  }
}
