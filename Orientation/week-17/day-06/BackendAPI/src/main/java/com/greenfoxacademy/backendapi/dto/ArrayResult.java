package com.greenfoxacademy.backendapi.dto;

public class ArrayResult {

  private Integer[] result;

  public ArrayResult(Integer[] result) {
    this.result = result;
  }

  public Integer[] getResult() {
    return result;
  }

  public void setResult(Integer[] result) {
    this.result = result;
  }
}
