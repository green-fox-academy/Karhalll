package com.greenfoxacademy.backendapi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Greeter {

  @JsonProperty("welcome_message")
  private String welcomeMessage;

  public Greeter(String name, String title) {
    this.welcomeMessage = "Oh, hi there " + name + ", my dear " + title + "!";
  }

  public String getWelcomeMessage() {
    return welcomeMessage;
  }

  public void setWelcomeMessage(String welcomeMessage) {
    this.welcomeMessage = welcomeMessage;
  }
}
