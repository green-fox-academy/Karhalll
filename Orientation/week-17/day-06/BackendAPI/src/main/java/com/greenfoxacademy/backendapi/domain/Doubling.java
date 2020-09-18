package com.greenfoxacademy.backendapi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doubling {

  private Integer received;
  private Integer result;
  private String error;

  public Doubling() {
    this.received = null;
    this.result = null;
    this.error = "Please provide an input!";
  }

  public Doubling(Integer received) {
    this.received = received;
    this.result = received * 2;
  }

  public Integer getReceived() {
    return received;
  }

  public void setReceived(Integer received) {
    this.received = received;
  }

  public Integer getResult() {
    return result;
  }

  public void setResult(Integer result) {
    this.result = result;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
