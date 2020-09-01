package com.greenfox.programmingfoxclub.model.history;

import java.time.LocalDateTime;

public class HistoryAction {
  private final LocalDateTime date;
  private final String action;

  protected HistoryAction(String action) {
    date = LocalDateTime.now();
    this.action = action;
  }

  public LocalDateTime getDate() {
    return date;
  }

  @Override
  public String toString() {
    return date + " : " + action;
  }
}
