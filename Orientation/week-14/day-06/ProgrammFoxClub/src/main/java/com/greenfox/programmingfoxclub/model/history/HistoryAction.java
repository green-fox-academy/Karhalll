package com.greenfox.programmingfoxclub.model.history;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HistoryAction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private LocalDateTime date;
  private String action;

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
