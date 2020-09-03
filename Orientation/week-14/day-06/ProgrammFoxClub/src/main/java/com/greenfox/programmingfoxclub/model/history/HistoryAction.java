package com.greenfox.programmingfoxclub.model.history;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
    return date.getYear() + ". "
        + date.getMonth().toString().toLowerCase()
        + " " + date.getDayOfMonth() + ". "
        + date.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME)
        + " : " + action;
  }
}
