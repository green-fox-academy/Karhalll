package com.greenfoxacademy.backendapi.dto;

public class LogDTO {

  private final Integer id;
  private final String endpoint;
  private final String data;

  public LogDTO(Integer id, String endpoint, String data) {
    this.id = id;
    this.endpoint = endpoint;
    this.data = data;
  }

  public Integer getId() {
    return id;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public String getData() {
    return data;
  }
}
