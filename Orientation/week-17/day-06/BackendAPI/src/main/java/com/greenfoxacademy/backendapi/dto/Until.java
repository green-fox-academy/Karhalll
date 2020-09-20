package com.greenfoxacademy.backendapi.dto;

public class Until {

  private Integer until;

  public Until() {
  }

  public Integer getUntil() {
    return until;
  }

  public void setUntil(Integer until) {
    this.until = until;
  }

  @Override
  public String toString() {
    if (until == null) {
      return "null";
    }
    return until.toString();
  }
}
